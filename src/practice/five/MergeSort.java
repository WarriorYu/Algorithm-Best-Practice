package practice.five;

import practice.MySortTestHelper;

import java.util.Arrays;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/6
 * Describe : O(nlogn) O(n)
 */
public class MergeSort {
    private MergeSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;
        int middle = l + (r - l) / 2;
        sort(arr, l, middle);
        sort(arr, middle + 1, r);
        merge(arr, l, middle, r);
    }

    private static void merge(Comparable[] arr, int l, int middle, int r) {
        Comparable[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = middle + 1;
        for (int k = l; k <= r; k++) {
            if (i > middle) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) > 0) {
                arr[k] = temp[j - l];
                j++;
            } else {
                arr[k] = temp[i - l];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = MySortTestHelper.generateNearlyOrderedArray(n, n);
        MySortTestHelper.printArray(arr);
        MySortTestHelper.testSort("practice.five.MergeSort", arr);
        MySortTestHelper.printArray(arr);
    }
}
