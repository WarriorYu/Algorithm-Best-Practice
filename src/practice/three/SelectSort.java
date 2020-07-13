package practice.three;

import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/13
 * Describe :  时间O(n^2) 空间O(1) 原地  不稳定
 */
public class SelectSort {
    private SelectSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                // TODO: 2020/7/13 这里要注意是和 arr[min]比较，而不是arr[j-1]
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                swap(arr, i, min);
            }
        }

    }

    public static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(arr);
        MySortTestHelper.testSort("practice.three.SelectSort", arr);
        MySortTestHelper.printArray(arr);
    }
}
