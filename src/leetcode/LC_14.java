package leetcode;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/13
 * Describe : 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 */
public class LC_14 {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //令最长公共前缀 prefix 的值为第一个字符串，进行初始化
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            //如果indexOf返回值是0，则与第一个字符串完全匹配，如果返回不是0,把字符串长度减1后继续匹配
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
