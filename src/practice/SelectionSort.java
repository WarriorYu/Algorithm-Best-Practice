package practice;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/5
 * Describe : 选择排序  时间复杂度O(n^2)  空间复杂度O(1)   原地、不稳定排序。
 *
 * 概念：选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 * 不稳定排序：选择排序每次都要找剩余未排序元素中的最小值，并和前面的元素交换位置，这样破坏了稳定性。
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // 寻找[i,n)区间里的最小值
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }
            //别忘了要判断min!=i时再交换
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] array = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(array);
        MySortTestHelper.testSort("practice.SelectionSort", array);
        MySortTestHelper.printArray(array);
    }

}
