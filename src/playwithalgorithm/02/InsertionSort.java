import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/6/9
 * Describe : 插入排序
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //写法一:
        /*for (int i = 0; i < n; i++) {
            for (int j = i; j >0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }*/

        //写法二:
        /*for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }*/

        //写法三：
       /* for (int i = 0; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(e) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }*/
        for (int i = 0; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }

    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 1, 20);
        SortTestHelper.testSort("InsertionSort", arr);
        SortTestHelper.printArray(arr);
    }
}
