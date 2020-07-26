package practice;

import playwithalgorithm.two.SortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/26
 * Describe :
 */
public class QuickSort {
    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
            }
        }

        swap(arr,l,j);
        return j;
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = MySortTestHelper.generateNearlyOrderedArray(10, 10);
        MySortTestHelper.printArray(array);

        MySortTestHelper.testSort("practice.QuickSort", array);
        MySortTestHelper.printArray(array);
    }
}
