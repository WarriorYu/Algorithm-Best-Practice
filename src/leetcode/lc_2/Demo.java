package leetcode.lc_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/16
 * Describe :
 */
public class Demo {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));

        String s = "cbabcb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String c = strs[i];
            while (c.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }

        }
        return prefix;

    }

    public static int lengthOfLongestSubstring(String s) {

        int ans = 0;
        //map里保存每个字符的索引+1
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                //"abcbefcioac"
                //防止start左移，所以取最大值
                start = Math.max(start, map.get(c));
            }
            //这里加1有两个原因：
            // 1.如果有重复的字符，即执行了上面的if里的语句，因为start的值get(c)出来的是实际start索引的下一位，所以这里加1
            // 2.如果没有重复的字符，ans的值是end-start+1
            ans = Math.max(ans, end - start + 1);

            map.put(c, end + 1);
        }
        return ans;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;

    }
}
