package com.r92ad8.practice.core.utils;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.*;
import org.joda.time.base.AbstractInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 日期操作类 ClassName: DateUtil
 *
 * @author Justin
 * @Description:
 * @date 2016年3月4日 下午3:58:19
 */
public class DateUtil {
    private DateUtil() {
    }


    /**
     * 一周的开始为周一, 用 1 标识
     */
    public static final int START_OF_WEEK = 1;

    /**
     * 一周的结束为周日, 用 7 标识
     */
    public static final int END_OF_WEEK = 7;

    /**
     * 一周 7 天
     */
    public static final int DAYS_OF_WEEK = 7;

    /**
     * 日期格式: YYYY-MM-dd
     */
    public static final String FORMAT_DATE = "YYYY-MM-dd";

    public static final String CHS_FORMAT_DATE = "YYYY年MM月dd日";

    /**
     * 日期时间格式: yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 不含秒的日期时间格式: yyyy-MM-dd HH:mm
     */
    public static final String FORMAT_DATE_TIME_WITHOUT_SECOND = "yyyy-MM-dd HH:mm";

    /**
     * 时间格式: HH:mm
     */
    public static final String FORMAT_HOUR_MINUTE = "HH:mm";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern(FORMAT_DATE);

    private static final DateTimeFormatter CHS_DATE_FORMATTER = DateTimeFormat.forPattern(CHS_FORMAT_DATE);

    private static final DateTimeFormatter SIMPLE_DATE_TIME_FORMATTER = DateTimeFormat.forPattern(FORMAT_DATE_TIME_WITHOUT_SECOND);

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(FORMAT_DATE_TIME);

    private static final DateTimeFormatter HOUR_MINUTE_FORMATTER = DateTimeFormat.forPattern(FORMAT_HOUR_MINUTE);

    private static final String START_DATE_CAN_NOT_BE_NULL = "start date can't be null";

    private static final String END_DATE_CAN_NOT_BE_NULL = "end date can't be null";

    /**
     * 解析日期, 格式: YYYY-MM-dd
     */
    public static Date parseDate(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        return DATE_FORMATTER.parseDateTime(dateString).toDate();
    }

    /**
     * 格式化日期时间输出, 格式: YYYY-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String printDateTime(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        return DATE_TIME_FORMATTER.print(date.getTime());
    }

    /**
     * 格式化时间的输出, 格式: HH:mm
     */
    public static String printHourMinut(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        return HOUR_MINUTE_FORMATTER.print(date.getTime());
    }

    /**
     * 解析时间, 格式: HH:mm
     */
    public static Date parseHourMinut(String timeString) {
        if (StringUtils.isBlank(timeString)) {
            return null;
        }
        return HOUR_MINUTE_FORMATTER.parseDateTime(timeString).toDate();
    }

    /**
     * 解析日期，格式：yyyy-MM-dd HH:mm
     *
     * @param dateString
     * @return
     */
    public static Date parseSimpleDatetime(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        return SIMPLE_DATE_TIME_FORMATTER.parseDateTime(dateString).toDate();
    }

    /**
     * 解析日期，格式：yyyy-MM-dd HH:mm:ss
     *
     * @param dateString
     * @return
     */
    public static Date parseDatetime(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        return DATE_TIME_FORMATTER.parseDateTime(dateString).toDate();
    }

    /**
     * 格式化日期, 格式: YYYY-MM-dd
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        return DATE_FORMATTER.print(date.getTime());
    }

    /**
     * 格式化日期, 格式: YYYY年MM月dd
     */
    public static String formatChsDate(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        return CHS_DATE_FORMATTER.print(date.getTime());
    }

    /**
     * 按照参数format的格式，日期转字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return StringUtils.EMPTY;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
    }

    /**
     * 按照参数format格式化
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(String date, String format) {
        if (date == null) {
            return StringUtils.EMPTY;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
    }

    /**
     * 获取日期对应的星期, 1 代表周一, 7 为周日
     *
     * @param date
     * @return
     */
    public static int dayOfWeek(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("date can not be null");
        }
        return new DateTime(date).getDayOfWeek();
    }


    /**
     * 获取当前日期和时间
     */
    public static Date getCurrentDateTime() {
        return new Date();
    }

    /**
     * 获取当前日期, 不包括时间
     */
    public static Date getCurrentDate() {
        return DateTime.now().withTime(0, 0, 0, 0).toDate();
    }

    /**
     * 获取两个日期相差的天数
     */
    public static int daysBetween(Date start, Date end) {
        if (start == null) {
            throw new IllegalArgumentException(START_DATE_CAN_NOT_BE_NULL);
        }
        if (end == null) {
            throw new IllegalArgumentException(END_DATE_CAN_NOT_BE_NULL);
        }
        return Days.daysBetween(new DateTime(start.getTime()), new DateTime(end.getTime())).getDays();
    }

    /**
     * 获取两个日期相差的天数
     */
    public static int daysBetween(DateTime start, DateTime end) {
        if (start == null) {
            throw new IllegalArgumentException(START_DATE_CAN_NOT_BE_NULL);
        }
        if (end == null) {
            throw new IllegalArgumentException(END_DATE_CAN_NOT_BE_NULL);
        }
        return Days.daysBetween(start, end).getDays();
    }

    /**
     * 获取一个日期区间每天对应的星期, 1 表示周一, 从周一到周日, 以此类推数值对应的星期
     *
     * @param start
     * @param end
     * @return
     */
    public static int[] daysOfWeekBetween(Date start, Date end) {
        if (start == null) {
            throw new IllegalArgumentException(START_DATE_CAN_NOT_BE_NULL);
        }
        if (end == null) {
            throw new IllegalArgumentException(END_DATE_CAN_NOT_BE_NULL);
        }
        DateTime startDateTime = new DateTime(start, DateTimeZone.forID("Asia/Shanghai"));
        DateTime endDateTime = new DateTime(end, DateTimeZone.forID("Asia/Shanghai"));
        int days = daysBetween(startDateTime, endDateTime);
        int[] result = new int[days + 1];
        result[0] = startDateTime.dayOfWeek().get();
        for (int i = 1; i <= days; i++) {
            result[i] = startDateTime.plusDays(i).dayOfWeek().get();
        }
        return result;
    }

    /**
     * 判断某个日期是周几
     *
     * @param dt
     * @return
     */
    public static int getWeekOfDate(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int result = (cal.get(Calendar.DAY_OF_WEEK) - 1 + 7) % 7;
        if (result == 0) {
            return 7;
        }
        return result;

    }

    /**
     * 获取一个区间的所有日期, 包括起始和结束
     */
    public static List<Date> betweenDays(Date start, Date end) {
        List<DateTime> dateTimes = betweenDateTime(start, end);
        return dateTimes.stream()
                .map(AbstractInstant::toDate)
                .collect(Collectors.toList());
    }

    /**
     * 获取一个区间的所有日期, 不包括结束日期
     */
    public static List<Date> betweenDaysExcludeEndDate(Date start, Date end) {
        if (start == null) {
            throw new IllegalArgumentException(START_DATE_CAN_NOT_BE_NULL);
        }
        if (end == null) {
            throw new IllegalArgumentException(END_DATE_CAN_NOT_BE_NULL);
        }
        List<Date> dateList = betweenDays(start, end);
        return dateList.stream().filter(date -> date.compareTo(end) < 0).collect(Collectors.toList());
    }

    /**
     * 获取一个区间的所有日期, 包括起始和结束
     */
    public static List<DateTime> betweenDateTime(Date start, Date end) {
        if (start == null) {
            throw new IllegalArgumentException(START_DATE_CAN_NOT_BE_NULL);
        }
        if (end == null) {
            throw new IllegalArgumentException(END_DATE_CAN_NOT_BE_NULL);
        }
        DateTime startDateTime = new DateTime(start);
        DateTime endDateTime = new DateTime(end);
        int days = daysBetween(startDateTime, endDateTime);
        List<DateTime> result = Lists.newArrayListWithCapacity(days + 1);
        result.add(startDateTime);

        for (int i = 1; i <= days; ++i) {
            result.add(startDateTime.plusDays(i));
        }

        return result;
    }

    /**
     * 日期是否在指定日期区间内
     *
     * @param target
     * @param start
     * @param end
     * @return
     */
    public static boolean inDuration(Date target, Date start, Date end) {
        if (target == null) {
            throw new IllegalArgumentException("target date can't be null");
        }
        if (start == null) {
            throw new IllegalArgumentException(START_DATE_CAN_NOT_BE_NULL);
        }
        if (end == null) {
            throw new IllegalArgumentException(END_DATE_CAN_NOT_BE_NULL);
        }
        return compareDateOnly(target, start) >= 0 && compareDateOnly(target, end) <= 0;
    }

    /**
     * 增加指定的天数
     */
    public static Date addDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        return new DateTime(date.getTime()).plusDays(days).toDate();
    }

    /**
     * 减少指定的天数
     */
    public static Date subDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        return new DateTime(date.getTime()).minusDays(days).toDate();
    }

    /**
     * 增加指定的月
     */
    public static Date addMonths(Date date, int months) {
        if (date == null) {
            return null;
        }
        return new DateTime(date.getTime()).plusMonths(months).toDate();
    }

    /**
     * 减少指定的月
     */
    public static Date subMonths(Date date, int months) {
        if (date == null) {
            return null;
        }
        return new DateTime(date.getTime()).minusMonths(months).toDate();
    }

    /**
     * 判断日期 left 是否早于 right
     *
     * @param left
     * @param right
     * @return
     */
    public static boolean dateEarlier(Date left, Date right) {
        return compareDateOnly(left, right) < 0;
    }

    /**
     * 比较日期，相等返回 0;
     * left 先于 right, 返回负数
     * left 晚于 right, 返回正数
     * <p>
     * 2018-05-10 2018-05-10 返回 0
     * 2018-05-09 2018-05-10 返回负数
     * 2018-05-11 2018-05-10 返回正数
     */
    public static int compareDateOnly(Date left, Date right) {
        return DateTimeComparator.getDateOnlyInstance().compare(left, right);
    }

    /**
     * 比较时间
     */
    public static int comapreDateTime(Date left, Date right) {
        return DateTimeComparator.getInstance(DateTimeFieldType.secondOfMinute()).compare(left, right);
    }

    /**
     * 比较时间
     */
    public static int comapreDateTime(DateTime left, DateTime right) {
        return DateTimeComparator.getInstance(DateTimeFieldType.secondOfMinute()).compare(left, right);
    }

    /**
     * 比较 HH:mm
     *
     * @param left
     * @param right
     * @return
     */
    public static int compareHourAndMinute(Date left, Date right) {
        return compare(DateTimeFieldType.minuteOfDay(), DateTimeFieldType.dayOfYear(), left, right);
    }

    /**
     * 日期时间的比较, 需要指定比较的范围
     * <p>
     * 如：
     * DateUtil.compare(DateTimeFieldType.secondOfMinute(), DateTimeFieldType.dayOfMonth(), left, right);
     * 这个例子比较的是时分秒
     *
     * @param lowerLimit 要比较域的下限, null 表示无下限, 比较的时候包含该域值得比较
     * @param upperLimit 要比较域的上限, null 表示无上限, 比较的时候不包含该域值得比较
     * @param left
     * @param right
     * @return 相等返回 0, left 先于 right, 返回负数, left 晚于 right, 返回正数
     */
    public static int compare(DateTimeFieldType lowerLimit, DateTimeFieldType upperLimit, Date left, Date right) {
        return DateTimeComparator.getInstance(lowerLimit, upperLimit).compare(left, right);
    }

    /**
     * 获取一天的零点, 零点定义为 00:00:00.000
     */
    public static Date getStartOfDay(Date date) {
        return new DateTime(date).withTime(0, 0, 0, 0).toDate();
    }

    /**
     * 获取一天的结束, 这里的结束定义为 23:59:59.999
     */
    public static Date getEndOfDay(Date date) {
        return new DateTime(date).withTime(23, 59, 59, 999).toDate();
    }

    /**
     * 获取日期, 去除时间
     *
     * @param date
     * @return
     */
    public static Date getDateOnly(Date date) {
        return getStartOfDay(date);
    }

}
