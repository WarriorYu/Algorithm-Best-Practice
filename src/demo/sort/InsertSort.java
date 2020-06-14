package demo.sort;

import java.util.Arrays;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/6
 * Describe : 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 7, 6, 9, 0, 5, 3};
        for (int i : arr) {
            System.out.print(i + ",");

        }
        System.out.println();
        sort(arr);
        for (int i : arr) {
            System.out.print(i + ",");

        }
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
    }
    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

}
