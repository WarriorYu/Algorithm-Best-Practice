package playwithalgorithm.three;

import demo.sort.InsertSort;
/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/26
 * Describe :  快速排序
 *
 * 1.快排是一种原地、不稳定的排序算法
 * 2.快排的时间复杂度： O(nlogn)  。在极端情况下，才会退化到 O(n^2)
 */
public class QuickSort {
    private QuickSort() {
    }

    public static void main(String[] args) {
        Comparable[] arr = {1, 7, 2, 5, 9, 7, 8, 6};
        new QuickSort().sort(arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
        /*for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }*/
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;
        // 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertSort.sort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;


    }
}
