package playwithalgorithm.three;

import demo.sort.InsertSort;

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

    private static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];
        int j = l;
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
