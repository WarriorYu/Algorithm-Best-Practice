package leetcode;

import java.util.Stack;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/12
 * Describe :
 */
public class LC_20 {
    public static void main(String[] args) {
        String a = "aa{}haha";
        System.out.println(a.contains("{}"));
        Stack<Character> stack = new Stack<>();
    }

    /*public static boolean isValid(String s) {
        Stack<char> stack = new Stack<Char>();

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length/2; i++) {
            stack.push(array[i])
            if (array[i] == '(') {
                stack.push("(");
            } else if (array[i] == '{') {
                stack.push("{");
            } else if (array[i] == '[') {
                stack.push("【");
            }

        }


    }*/
}
