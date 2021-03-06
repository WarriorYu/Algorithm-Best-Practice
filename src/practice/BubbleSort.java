package practice;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/5
 * Describe : 优化的冒泡排序。
 *            时间复杂度O(n^2)  空间复杂度O(1)   原地、稳定排序
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 20;
        Integer[] array = MySortTestHelper.generateRandomArray(n, 0, n);
        MySortTestHelper.printArray(array);
        MySortTestHelper.testSort("practice.BubbleSort", array);
        MySortTestHelper.printArray(array);
    }
}
