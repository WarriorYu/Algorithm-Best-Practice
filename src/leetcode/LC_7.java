package leetcode;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/9/15
 * Describe :给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

             示例 1:

             输入: 123
             输出: 321
              示例 2:

             输入: -123
             输出: -321
             示例 3:

             输入: 120
             输出: 21
             注意:

             假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

             来源：力扣（LeetCode）
             链接：https://leetcode-cn.com/problems/reverse-integer
             著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_7 {
    /**
     * 测试用例
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-234));
        System.out.println(reverse(120));
    }


    /**
     * 解题算法
     * 原理：
     * 整数翻转，通过pop、push来完成
     * 1. pop  int pop = x %10; x/=10
     * 2. push int result = 0; result = result*10 + pop
     * 3. 注意整数溢出的情况
     * @param x
     * @return
     */

    public static int reverse(int x) {
        //结果变量
        int result = 0;
        while(x!=0){
            int pop = x % 10;
            x /=10;
            //处理溢出的问题
            //1. 如果是正数，result >Integer.MAX_VALUE/10 ||(result == Integer.MAX_VALUE/10 && poop > Integer.MAX_VALUE%10）会溢出
            //2. 如果是负数，result < Integer.MIN_VALUE/10 ||(result == Integer.MIN_VALUE/10 && poop < Integer.MIN_VALUE%10）会溢出
            if(result > Integer.MAX_VALUE/10 ||(result == Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE%10)) return 0;
            if(result < Integer.MIN_VALUE/10 ||(result == Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE%10)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }
}
