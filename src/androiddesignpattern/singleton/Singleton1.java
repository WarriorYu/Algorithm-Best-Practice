package androiddesignpattern.singleton;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/11
 * Describe : 单例：饿汉式
 */
public class Singleton1 {
    private static Singleton1 mInstance = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return mInstance;
    }


}
