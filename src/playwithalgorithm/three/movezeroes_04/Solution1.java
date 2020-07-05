import java.util.ArrayList;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/18
 * Describe : // 283. Move Zeroes
 * // https://leetcode.com/problems/move-zeroes/description/
 * // 时间复杂度: O(n)
 * // 空间复杂度: O(n)
 */
public class Solution1 {
    public static void main(String args[]) {

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution1()).moveZeroes(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private void moveZeroes(int[] arr) {
        ArrayList<Integer> nonZeroElements = new ArrayList<>();

        //将所有非0元素放入nonZeroElements中
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                nonZeroElements.add(arr[i]);
            }
        }
        // 将nonZeroElements中的所有元素依次放入到nums开始的位置
        for (int i = 0; i < nonZeroElements.size(); i++) {
            arr[i] = nonZeroElements.get(i);
        }

        //
        for (int i = nonZeroElements.size(); i < arr.length; i++) {
            arr[i] = 0;
        }

    }
}
