package practice.five;

import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/6
 * Describe : O(n^2) O(1)
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
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
        int n = 10;
        Integer[] arr = MySortTestHelper.generateNearlyOrderedArray(n, n);
        MySortTestHelper.printArray(arr);
        MySortTestHelper.testSort("practice.five.BubbleSort", arr);
        MySortTestHelper.printArray(arr);
    }
}
