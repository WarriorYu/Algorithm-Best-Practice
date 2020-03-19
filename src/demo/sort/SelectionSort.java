package demo.sort;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/6
 * Describe : 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
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

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }



}
