package demo.sort;

import java.util.Arrays;
import java.util.SortedMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/5
 * Describe : 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 1, 5, 4, 7, 6, 9, 0, 5, 3};
        for (int i : arr) {
            System.out.print(i + ",");

        }
        System.out.println();
        sort(arr);
        for (int i : arr) {
            System.out.print(i + ",");

        }

    }

    private static int[] sort(int[] sourceArray) throws Exception {
        //对参数进行拷贝
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < sourceArray.length; i++) {
            boolean flag = true;
            for (int j = 0; j < sourceArray.length - 1; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    int temp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                //没有交换，说明已经排好序
                break;
            }
        }
        return arr;


    }

}
