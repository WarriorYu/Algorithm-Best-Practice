package leetcode;

import com.sun.deploy.util.StringUtils;

import java.security.PublicKey;
import java.util.PriorityQueue;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/12/26
 * Describe : 125. 验证回文串
 */
public class LC_125 {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                left--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
