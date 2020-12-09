package com.r92ad8.practice.algorithm;

/**
 * 二分查找
 * 算法思想：又叫折半查找，要求待查找的序列有序。
 * 每次取中间位置的值与待查关键字比较，如果中间位置的值比待查关键字大，则在前半部分循环这个查找的过程，
 * 如果中间位置的值比待查关键字小，则在后半部分循环这个查找的过程。
 * 直到查找到了为止，否则序列中没有待查的关键字。
 */
public class BinarySearch {

    /**
     * 非递归实现
     *
     * @param array 数组
     * @param e     查找的值
     * @return
     */
    public static int binarySearch(int[] array, int e) {
        int min = 0;
        int max = array.length - 1;
        int middle;
        while (min <= max) {
            middle = (min + max) / 2;
            if (array[middle] == e) {
                return middle + 1;
            } else if (array[middle] < e) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param array
     * @param e
     * @param min
     * @param max
     * @return
     */
    public static int binarySearchRecursion(int[] array, int e, int min, int max) {

        int middle = (min + max) / 2;
        if (min > max) {
            return -1;
        }
        if (array[middle] == e) {
            return middle + 1;
        } else if (array[middle] < e) {
            return binarySearchRecursion(array, e, middle + 1, max);
        } else {
            return binarySearchRecursion(array, e, min, middle - 1);
        }
    }

}
