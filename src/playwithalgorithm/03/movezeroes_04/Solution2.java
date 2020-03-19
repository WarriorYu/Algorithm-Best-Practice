import java.util.ArrayList;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/18
 * Describe : // 283. Move Zeroes
 * // https://leetcode.com/problems/move-zeroes/description/
 * // 时间复杂度: O(n)
 * // 空间复杂度: O(1)
 */
public class Solution2 {
    public static void main(String args[]) {

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution2()).moveZeroes(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private void moveZeroes(int[] arr) {
        //将所有非0元素放入nonZeroElements中
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k++] = arr[i];
            }
        }
        for (int i = k; i < arr.length; i++) {
            arr[k] = 0;
        }
    }
}
