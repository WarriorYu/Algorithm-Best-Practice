//import demo.SubClass;
//
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;

import java.util.HashSet;
import java.util.List;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/6/15
 * Describe :
 */
public class Demo {
    public static void main(String[] args) {
//        String a = "😈";
//        System.out.println(a.length());
//        String b = "中";
//        System.out.println(b.length());
//        String longString = "aaaaaaaaaaaaaaaaa";
       /* try {
            ParameterizedType methodType = (ParameterizedType) SubClass.class.getMethod("getValue").getGenericReturnType();
            for (Type type : methodType.getActualTypeArguments()) {
                System.out.println(type);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }*/

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();

                interrupt();
                // 第一种判断中断的方法。判断是否被中断了，不会重置中断的状态，下次判断还是中断状态
                System.out.println("isInterrupted：" + isInterrupted());

                // 第二种判断中断的方法。判断是否被中断了，并且重置中断的状态，下次再判断则是非中断状态
                System.out.println("isInterrupted：" + Thread.interrupted());

                System.out.println("isInterrupted：" + isInterrupted());

                System.out.println("isInterrupted：" + Thread.interrupted());


            }
        };
        thread.start();

        /**
         * 打印结果：
         *
         * isInterrupted：true
         * isInterrupted：true
         * isInterrupted：false
         * isInterrupted：false
         */

    }


}
