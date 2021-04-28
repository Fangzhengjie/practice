package com.r92ad8.practice.demo.collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入:");
        int count = scanner.nextInt();
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        long b1 = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add("ok");
        }
        long e1 = System.nanoTime();
        long t1 = (e1 - b1);
        System.out.println("ArrayList添加" + count + "个数据耗时" + t1 + "纳秒");

        long b2 = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add("ok");
        }
        long e2 = System.nanoTime();
        long t2 = (e2 - b2);
        System.out.println("LinkedList添加" + count + "个数据耗时" + t2 + "纳秒");


        BigDecimal d1 = new BigDecimal(t1);
        BigDecimal d2 = new BigDecimal(t2);
        BigDecimal divide = d2.divide(d1, 2, BigDecimal.ROUND_HALF_UP);
        long r1 = divide.multiply(new BigDecimal(100)).longValue();
        System.out.println("LinkedList添加数据耗时是ArrayList的" + r1 + "%");

        long b3 = System.nanoTime();
        for (String s : arrayList) {
            s = "not";
        }
        long e3 = System.nanoTime();
        long t3 = (e3 - b3);
        System.out.println("ArrayList遍历" + count + "个数据耗时" + t3 + "纳秒");
        long b4 = System.nanoTime();
        for (String s : linkedList) {
            s = "not";
        }
        long e4 = System.nanoTime();
        long t4 = (e4 - b4);
        System.out.println("LinkedList遍历" + count + "个数据耗时" + t4 + "纳秒");

        BigDecimal d3 = new BigDecimal(t3);
        BigDecimal d4 = new BigDecimal(t4);
        BigDecimal divide2 = d4.divide(d3, 2, BigDecimal.ROUND_HALF_UP);
        long r2 = divide2.multiply(new BigDecimal(100)).longValue();
        System.out.println("LinkedList添加数据耗时是ArrayList的" + r2 + "%");

    }
}
