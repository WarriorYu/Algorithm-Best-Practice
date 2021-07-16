package practice.six;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import designPattern.bigtalkdesignpattern.facade.Facade;
import practice.MySortTestHelper;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/3/15
 * Describe :
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            // 如果一次循环没有交换任何数据，说明已经有序了，跳出循环
            if (!flag) {
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
        int n = 10;
        Integer[] arr = MySortTestHelper.generateNearlyOrderedArray(n, n);
        MySortTestHelper.printArray(arr);
        MySortTestHelper.testSort("practice.six.BubbleSort", arr);
        MySortTestHelper.printArray(arr);
    }
}
