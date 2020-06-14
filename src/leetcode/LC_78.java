package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_78 {

    private List<List<Integer>> res;

    private void find(int[] nums, int begin, List<Integer> pre) {
        // 没有显式的递归终止
        res.add(new ArrayList<>(pre));// 注意：Java 的引用传递机制，这里要 new 一下
        for (int i = begin; i < nums.length; i++) {
            pre.add(nums[i]);
            find(nums, i + 1, pre);
            pre.remove(pre.size() - 1);// 组合问题，状态在递归完成后要重置
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        List<Integer> pre = new ArrayList<>();
        find(nums, 0, pre);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new LC_78().subsets(nums);
    }
}

