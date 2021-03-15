package practice.six;

import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/3/15
 * Describe :
 */
public class InsertSort {
    private InsertSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int n = 20;
//        Integer[] array = MySortTestHelper.generateRandomArray(n, 0, n);
        Integer[] array = {9, 8, 6, 4, 7, 4, 5, 3, 2, 1};

        MySortTestHelper.printArray(array);
        MySortTestHelper.testSort("practice.InsertSort", array);
        MySortTestHelper.printArray(array);
    }
}
