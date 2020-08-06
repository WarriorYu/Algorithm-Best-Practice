package practice.five;

import demo.sort.InsertSort;
import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/6
 * Describe : O(n^2) O(1)
 */
public class InserSort {
    private InserSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Comparable p = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(p) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = p;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = MySortTestHelper.generateNearlyOrderedArray(n, n);
        MySortTestHelper.printArray(arr);
        MySortTestHelper.testSort("practice.five.InserSort", arr);
        MySortTestHelper.printArray(arr);
    }

}
