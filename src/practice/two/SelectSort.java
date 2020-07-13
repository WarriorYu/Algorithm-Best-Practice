package practice.two;

import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/10
 * Describe :
 */
public class SelectSort {
    private SelectSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
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
        sort(arr);
        MySortTestHelper.printArray(arr);
    }
}
