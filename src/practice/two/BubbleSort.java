package practice.two;

import playwithdatastructures.heap_and_priority_queue_08.SortTest;
import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/10
 * Describe :
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n=10;
        Integer[] arr = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(arr);
        sort(arr);
        MySortTestHelper.printArray(arr);
    }
}
