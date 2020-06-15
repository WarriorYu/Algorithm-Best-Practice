import java.util.Arrays;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/6/12
 * Describe : 归并排序
 */
public class MergeSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        // 优化2: 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int middle = l + (r - l) / 2;

        sort(arr, l, middle);
        sort(arr, middle + 1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[middle].compareTo(arr[middle + 1]) > 0) {
            merge(arr, l, middle, r);
        }
    }

    private static void merge(Comparable[] arr, int l, int middle, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = middle + 1;
        for (int k = l; k <= r; k++) {
            //如果左半部分元素已经全部处理完毕
            if (i > middle) {
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
        Integer[] array = SortTestHelper.generateNearlyOrderedArray(10, 10);
        SortTestHelper.printArray(array);

        SortTestHelper.testSort("MergeSort", array);
        SortTestHelper.printArray(array);
    }
}
