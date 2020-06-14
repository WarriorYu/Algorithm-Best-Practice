package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC_46 {
    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums, 0, p);

        return res;
    }

    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {

        System.out.println("index = " + index + " : p = " + p.toString());
        if (index == nums.length) {
            res.add((LinkedList<Integer>) p.clone());
            System.out.println("get " + p.toString() + " , return");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.addLast(nums[i]);
                System.out.println("index = " + index + " , addLast : nums[" + i + "] = " + nums[i] + " , p = " + p.toString());
                generatePermutation(nums, index + 1, p); 
                p.removeLast();
                used[i] = false;
                System.out.println("index = " + index + " , removeLast : nums[" + i + "] = " + nums[i] + ", p = " + p.toString());
            }
        }
        System.out.println("index = " + index + " , p = " + p.toString() + " complete,return");
        return;
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new LC_46()).permute(nums);
        for (List<Integer> list : res)
            printList(list);
    }
}
