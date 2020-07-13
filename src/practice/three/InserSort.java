package practice.three;

import demo.sort.InsertSort;
import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/13
 * Describe : 时间O(n^2) 空间O(1) 原地  稳定
 */
public class InserSort {
    private InserSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            Comparable e = arr[i];
            // TODO: 2020/7/13 这里是和e比较，而不是arr[j]
            for (; j > 0 && (arr[j - 1].compareTo(e) > 0); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(arr);
        MySortTestHelper.testSort("practice.three.InserSort", arr);
        MySortTestHelper.printArray(arr);
    }

}
