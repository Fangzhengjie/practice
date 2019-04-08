package com.r92ad8.practice.algorithm;

public class Fibonacci {

    /**
     * 斐波那契数列递归实现
     *
     * @param n
     * @return
     */
    public static long fibonacciRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    /**
     * 斐波那契数列非递归实现
     * n不能为0，因为n为0时，array大小为1，array[1]越界。
     *
     * @param n
     * @return
     */
    public static long fibonacci(int n) {
        long[] array = new long[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[n] = array[n - 1] + array[n - 2];
        }
        return array[n];
    }
}
