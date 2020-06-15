import demo.SubClass;
import demo.SuperClass;
import demo.function_interface.DemoLambda;
import leetcode.lc_2.ListNode;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/6/15
 * Describe :
 */
public class Demo {
    public static void main(String[] args) {
        String a = "😈";
        System.out.println(a.length());
        String b = "中";
        System.out.println(b.length());
        String longString = "aaaaaaaaaaaaaaaaa";
        try {
            ParameterizedType methodType = (ParameterizedType) SubClass.class.getMethod("getValue").getGenericReturnType();
            for (Type type : methodType.getActualTypeArguments()) {
                System.out.println(type);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    Runnable a = new Runnable() {
        @Override
        public void run() {

        }
    };

    public void a(List<Integer> list) {

    }

}
