package practice.three;

import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/13
 * Describe : 时间O(n^2) 空间O(1) 原地 稳定
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 20;
        Integer[] array = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(array);
        MySortTestHelper.testSort("practice.three.BubbleSort", array);
        MySortTestHelper.printArray(array);
    }


}
