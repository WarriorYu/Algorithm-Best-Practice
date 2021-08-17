package demo.sort;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/3
 * Describe :
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 7, 5, 3, 7, 9, 0};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean change = false;
            for (int j = 0; j < n - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
