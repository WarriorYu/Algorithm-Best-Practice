package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/01/10
 * Describe : 76. 最小覆盖子串
 *
 * 注意：使用Pair类在leetcode报无法找到这个类
 */
public class LC_76 {


    public static void main(String[] args) {
    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        //记录最小子串的起始位置和长度
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        //左右指针
        int left = 0, right = 0;

        //t中包含的字符，记录每个字符出现的次数
        HashMap<Character, Integer> needs = new HashMap<>();
        //滑动窗口window
        HashMap<Character, Integer> window = new HashMap<>();

        ArrayList<Pair<Integer, Character>> filtereds = new ArrayList<>();

        for (Character c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (needs.containsKey(c)) {
                filtereds.add(new Pair<>(i, c));
            }
        }

        //记录滑动窗口window和needs中匹配的个数
        int match = 0;

        while (right <filtereds.size()) {
            //window的right往右滑动
//            char c1 = s.charAt(right);
            char c1 = filtereds.get(right).getValue();
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).compareTo(needs.get(c1))==0) {
                    //该字母c在needs和window中的个数已经完全匹配，match加一
                    match++;
                }
            }
            while (match == needs.size()) {
                //匹配成功，记录起始位置和长度
                 start = filtereds.get(left).getKey();
                int end = filtereds.get(right).getKey();

                if (end - start +1< minLen) {
                    minLen = end - start+1;
                }
//                char c2 = s.charAt(left);
                char c2 = filtereds.get(left).getValue();
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2).compareTo(needs.get(c2))<0) {
                        //window中c2个数小于needs中的，匹配数减一
                        match--;
                    }
                }
                left++;
            }
            right++;

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
