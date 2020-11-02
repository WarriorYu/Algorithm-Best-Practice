package practice;

import java.util.Stack;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/11/2
 * Describe : 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char c = stack.pop();
                char match;
                if (s.charAt(i) == ')') {
                    match = '(';
                } else if (s.charAt(i) == ']') {
                    match = '[';
                } else if (s.charAt(i) == '}') {
                    match = '{';
                } else {
                    return false;
                }
                if (c != match) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
