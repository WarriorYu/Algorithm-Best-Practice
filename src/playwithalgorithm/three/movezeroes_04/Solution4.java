import java.util.ArrayList;
import java.util.jar.JarEntry;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/18
 * Describe : // 283. Move Zeroes
 * // https://leetcode.com/problems/move-zeroes/description/
 * // 时间复杂度: O(n)
 * // 空间复杂度: O(1)
 */
public class Solution4 {
    public static void main(String args[]) {

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution4()).moveZeroes(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private void moveZeroes(int[] arr) {
        //将所有非0元素放入nonZeroElements中
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                //如果非0,则交换。如果都是非0的数，没必要自己和自己交换，所以加一层判断
                if (k != i) {
                    swap(arr, k++, i);
                } else {
                    k++;
                }
            }
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
