package practice;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/5
 * Describe : 插入排序：时间复杂度O(n^2)  空间复杂度O(1)   原地、稳定排序
 * <p>
 * 插入排序：首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，
 * 就是数组的第一个元素。插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，
 * 并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
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
                arr[j] = arr[j - 1];
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
