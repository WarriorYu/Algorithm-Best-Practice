package practice;

import playwithalgorithm.two.InsertionSort;
import playwithalgorithm.two.SortTestHelper;

import java.util.Arrays;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/26
 * Describe : 归并排序
 * <p>
 * 时间复杂度O(nlogn)  空间复杂度O(n),使用了额外的数组来排序   不是原地排序  是稳定排序
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
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = MySortTestHelper.generateNearlyOrderedArray(10, 10);
        MySortTestHelper.printArray(array);

        MySortTestHelper.testSort("practice.MergeSort", array);
        MySortTestHelper.printArray(array);
    }
}
