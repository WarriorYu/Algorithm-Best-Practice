import playwithalgorithm.two.SortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/6/16
 * Describe : 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
 */
public class HeapSort {
    // 我们的算法类不允许产生任何实例
    private HeapSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0) {
                j++;
            }
            if (arr[k].compareTo(arr[j]) >= 0) break;
            swap(arr, j, k);
            k = j;
        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 测试 HeapSort
    public static void main(String[] args) {

        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
        SortTestHelper.printArray(arr);

        SortTestHelper.testSort("HeapSort", arr);
        SortTestHelper.printArray(arr);

        return;
    }
}
