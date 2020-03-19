package demo.function_interface;


import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/29
 * Describe :
 */
public class DemoLogger {
    private static void log(int level, MessageBuilder builder) {
        if (level == 1) {
            System.out.println(builder.buildMessage());
        }

    }

    public static void main(String[] args) {
        //基本Lambda的使用
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        log(2, () -> {
                    System.out.println("执行拼接了");
                    return msgA + msgB + msgC;
                }
        );
        String[] array = {msgA, msgB, msgC};
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, (String a, String b) -> a.length() - b.length());
        System.out.println(Arrays.toString(array));

        System.out.println(msgA.substring(0, msgA.length() - 1));
    }


}
