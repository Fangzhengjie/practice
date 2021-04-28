package com.r92ad8.practice.demo.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.UUID;

/**
 * 分布式唯一ID生成器，源自snowflake项目的scala版本
 * <p>
 * 生成规则如下：
 * <p>
 * 64位ID (42(毫秒)+5(机器ID)+5(业务编码)+12(重复累加))
 *
 * @author Fangzhengjie
 * @date 2020-04-02
 */
@Slf4j
public class IdWorker {

    private static final long TWEPOCH = 1288834974657L;

    // 机器标识位数
    private static final long WORKERID_BITS = 5L;

    // 数据中心标识位数
    private static final long DATACENTERID_BITS = 5L;

    // 机器ID最大值
    private static final long MAX_WORKER_ID = (-1L ^ (-1L << WORKERID_BITS));

    // 数据中心ID最大值
    private static final long MAX_DATACENTER_ID = (-1L ^ (-1L << DATACENTERID_BITS));

    // 毫秒内自增位
    private static final long SEQUENCE_BITS = 12L;

    // 机器ID偏左移12位
    private static final long WORKERID_SHIFT = SEQUENCE_BITS;

    // 数据中心ID左移17位
    private static final long DATACENTERID_SHIFT = SEQUENCE_BITS + WORKERID_BITS;

    // 时间毫秒左移22位
    private static final long TIMESTAMP_LEFTSHIFT = SEQUENCE_BITS + WORKERID_BITS + DATACENTERID_BITS;

    private static final long SEQUENCE_MASK = (-1L ^ (-1L << SEQUENCE_BITS));

    private static long lastTimestamp = -1L;
    // 0，并发控制
    private long sequence = 0L;

    private final long workerId;
    // 数据标识id部分
    private final long datacenterId;


    public IdWorker() {
        this.datacenterId = getDataCenterId(MAX_DATACENTER_ID);
        this.workerId = getMaxWorkerId(datacenterId, MAX_WORKER_ID);
    }


    /**
     * @param workerId     工作机器ID
     * @param dataCenterId 序列号
     */
    public IdWorker(long workerId, long dataCenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (dataCenterId > MAX_DATACENTER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", MAX_DATACENTER_ID));
        }
        this.workerId = workerId;
        this.datacenterId = dataCenterId;
    }


    /**
     * <p>
     * 获取 maxWorkerId
     * </p>
     */
    protected static long getMaxWorkerId(long dataCenterId, long maxWorkerId) {
        StringBuffer mpid = new StringBuffer();
        mpid.append(dataCenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (!name.isEmpty()) {
            /*
             * GET jvmPid
             */
            mpid.append(name.split("@")[0]);
        }
        /*
         * MAC + PID 的 hashcode 获取16个低位
         */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }

    /**
     * <p>
     * 数据标识id部分
     * </p>
     */
    protected static long getDataCenterId(long maxDataCenterId) {
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                id = ((0x000000FF & (long) mac[mac.length - 1])
                        | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
                id = id % (maxDataCenterId + 1);
            }
        } catch (Exception e) {
            System.out.println(" getDatacenterId: " + e.getMessage());
        }
        return id;
    }


    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            try {
                throw new IllegalArgumentException("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
            } catch (Exception e) {
                log.error("Error!", e);
            }
        }

        if (lastTimestamp == timestamp) {
            // 当前毫秒内，则+1
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                // 当前毫秒内计数满了，则等待下一秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        // ID偏移组合生成最终的ID，并返回ID
        long nextId = ((timestamp - TWEPOCH) << TIMESTAMP_LEFTSHIFT) | (datacenterId << DATACENTERID_SHIFT) | (workerId << WORKERID_SHIFT) | sequence;
        return nextId;
    }

    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 使用UUID的hashcode生成12位订单编号。 暂时machineId先设定为1；测试过1秒1000单不会有重复，5万条以上会有2条重复。
     *
     * @return
     */
    public static long getOrderIdByUUID() {
        int machineId = 1;// 最大支持1~9个集群部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        return Long.valueOf(machineId + String.format("%011d", hashCodeV));
    }

    public static String generate() {
        return String.valueOf(new IdWorker().nextId());
    }
}
