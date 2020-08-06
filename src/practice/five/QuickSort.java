package practice.five;

import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/6
 * Describe :
 */
public class QuickSort {
    private QuickSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int partition = partition(arr, l, r);
        sort(arr, l, partition-1);
        sort(arr,partition+1,r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];
        int j = l;
        for (int i = l+1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,j,l);
        return j;
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
        MySortTestHelper.testSort("practice.five.QuickSort", arr);
        MySortTestHelper.printArray(arr);
    }
}
