package demo.function_interface;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/29
 * Describe : 函数式接口练习
 */
public class DemoLambda {

    public static void main(String[] args) {
        //调用使用函数式接口的方法
        show(() -> System.out.println("哈哈"));

        //Supplier接口
        String res = getString(() -> "我是Supplier，get()返回的数据");
        System.out.println(res);

        //Consumer
        consumeString((a) -> {
            System.out.println(a);
        });
        //只有一个参数的方法，可以省略小括号，只有一行代码可以省略中括号
        consumeString(a-> System.out.println(a));

        //默认方法:andThen:消费数据的时候，首先做一个操作， 然后再做一个操作
        consumerAndThen("Hello", (a) -> System.out.println(a.toUpperCase()), (b) -> System.out.println(b.toLowerCase()));

        //练习andThen
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        printInfo(one -> System.out.print("姓名：" + one.split(",")[0]), one -> System.out.println("性别： " + one.split(",")[1]), array);


    }


    //使用自定义的函数式接口作为方法参数
    private static void show(MyFunctionInterface myInter) {
        //调用自定义的函数式接口
        myInter.load();
    }

    private static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    private static void consumeString(Consumer<String> consumer) {
        consumer.accept("我是Consume，accept()的数据");
    }

    private static void consumerAndThen(String s, Consumer<String> a, Consumer<String> b) {
        a.andThen(b).accept(s);
    }

    private static void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) {
            one.andThen(two).accept(info);
        }

    }
}
