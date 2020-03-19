package leetcode;

import java.util.HashMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/13
 * Describe : 3. 无重复字符的最长子串
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LC_3 {


    public static void main(String[] args) {
        String s = "cbabcb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                //防止start左移，所以这里取最大值
                start = Math.max(map.get(c), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(c, end + 1);
        }
        return ans;
    }
}
