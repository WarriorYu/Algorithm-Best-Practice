package leetcode;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/9/15
 * Describe :判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

             示例 1:

             输入: 121
             输出: true
             示例 2:

             输入: -121
             输出: false
             解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
             示例 3:

             输入: 10
             输出: false
             解释: 从右向左读, 为 01 。因此它不是一个回文数。

             来源：力扣（LeetCode）
             链接：https://leetcode-cn.com/problems/palindrome-number
             著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_9 {

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));

    }

    /**
     * 解题算法
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        //1. 如果x <0，因为是负数，肯定不是回文数，如果x的最后一位是0，只有x=0满足，因此要判断x!=0 && x%10=0(x的最后一位==0)
        if(x<0 || x !=0 && x % 10 ==0) return false;
        //2. 如果是回文数，比如12321，反转后半部分数字，通过除以10和对10求余的方法。
        int reversedNumber = 0;
        while(x>reversedNumber){
            int pop = x % 10;
            reversedNumber = reversedNumber * 10 +pop;
            x /= 10;
        }
        //对于12321，x=12,reversedNumber=123,通过reversedNumber/10去除中间位3
        return x== reversedNumber || x==reversedNumber/10;
    }
}
