package practice.six;

import playwithalgorithm.two.SortTestHelper;
import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/3/15
 * Describe : O(n^2)
 */
public class SelectSort {
    private SelectSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].compareTo(arr[min])<0){
                    min = j;
                }
            }
            if (min!=i){
                swap(arr,i,min);
            }
        }
    }

    private static void swap(Comparable[] arr, int a, int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] array = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(array);
        MySortTestHelper.testSort("practice.six.SelectSort", array);
        MySortTestHelper.printArray(array);
    }
}
