package practice.five;

import practice.MySortTestHelper;

import java.util.concurrent.ConcurrentMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/6
 * Describe : O(n^2) o(1)
 */
public class SelectSort {
    private SelectSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }
            if (i != min) {
                swap(arr, i, min);
            }

        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = MySortTestHelper.generateNearlyOrderedArray(n, n);
        MySortTestHelper.printArray(arr);
        MySortTestHelper.testSort("practice.five.SelectSort", arr);
        MySortTestHelper.printArray(arr);
    }

}
