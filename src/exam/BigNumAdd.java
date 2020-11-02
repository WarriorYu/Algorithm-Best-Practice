package exam;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/24
 * Describe :
 */
public class BigNumAdd {
    private static String s1 = "8763845638363774673957584937685934737";
    private static String s2 = "763845638363774673957584937685934";

    public static void main(String[] args) {
        String result = add(s1, s2);
        System.out.println(result);
    }

    private static String add(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
// 对位数少的String高位补0，使得两个字符串一样长
        int diff = len1 > len2 ? (len1 - len2) : (len2 - len1);
        StringBuilder builder = null;
        if (len1 > len2) {
            builder = new StringBuilder(s2);
            while (diff > 0) {
                builder.insert(0, "0");
                diff--;
            }
            s2 = builder.toString();
        } else if (len1 < len2) {
            builder = new StringBuilder(s1);
            while (diff > 0) {
                builder.insert(0, "0");
                diff--;
            }
            s1 = builder.toString();
        }
        String[] array1 = s1.split("");
        String[] array2 = s2.split("");
        int len = s1.length();
// 进位
        int carry = 0;
        StringBuilder ans = new StringBuilder();
// 从低位开始遍历
        for (int i = len - 1; i >= 0; i--) {
            int count = Integer.valueOf(array1[i]) +Integer.parseInt( array2[i] )+ carry;
// 本位的值
            int cur = count % 10;
// 进位
            carry = count / 10;
            ans.append(cur);
        }
        if (carry != 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
