package androiddesignpattern.singleton;

import designPattern.singleton.SingTon2;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/11
 * Describe : 单例：懒汉式
 */
public class Singleton2 {
    private static Singleton2 mInstance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton2();
        }

        return mInstance;
    }
}
