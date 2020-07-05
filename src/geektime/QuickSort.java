package geektime;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/4/25
 * Describe : 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 6, 5, 9, 7, 8};
        quickSort(arr, arr.length);
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
    }

    /**
     * @param arr
     * @param n   数组的大小
     */
    private static void quickSort(int[] arr, int n) {
        quickSortInternally(arr, 0, n - 1);

    }

    /**
     * 递归函数
     *
     * @param arr
     * @param p
     * @param r
     */
    private static void quickSortInternally(int[] arr, int p, int r) {
        //区间缩小为 1，就说明所有的数据都有序了。
        if (p >= r) return;
        int q = partition(arr, p, r);
        quickSortInternally(arr, p, q - 1);
        quickSortInternally(arr,q+1,r);
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i++] = temp;
                }
            }
        }
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }

}
