package playwithalgorithm.three;

import playwithalgorithm.two.InsertionSort;
import playwithalgorithm.two.SortTestHelper;

import java.util.Arrays;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/6/12
 * Describe : 归并排序
 *
 * 1.时间复杂度：复杂度是非常稳定的，不管是最好情况、最坏情况，还是平均情况，时间复杂度都是 O(nlogn)。
 *
 * 2.空间复杂度：实际上，递归代码的空间复杂度并不能像时间复杂度那样累加。刚刚我们忘记了最重要的一点，
 *  那就是，尽管每次合并操作都需要申请额外的内存空间，但在合并完成之后，临时开辟的内存空间就被释放掉了。
 *  在任意时刻，CPU 只会有一个函数在执行，也就只会有一个临时的内存空间在使用。临时内存空间最大也不会超过 n 个数据的大小，所以空间复杂度是 O(n)。
 *
 * 3.否是原地排序算法：归并排序不是原地排序算法。这是因为归并排序的合并函数，在合并两个有序数组为一个有序数组时，需要借助额外的存储空间.
 * 4.归并排序是一个稳定的排序算法。归并排序稳不稳定关键要看 merge() 函数，也就是两个有序子数组合并成一个有序数组的那部分代码。
 */
public class MergeSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
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

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
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
                // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {
                // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = SortTestHelper.generateNearlyOrderedArray(10, 10);
        SortTestHelper.printArray(array);

        SortTestHelper.testSort("playwithalgorithm.three.MergeSort", array);
        SortTestHelper.printArray(array);
    }
}
