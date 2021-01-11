package androiddesignpattern.singleton;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/11
 * Describe : 单例：静态内部类
 */
public class Singleton4 {

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        // 当调用这个方法的时候，才会加载静态内部类。保证了懒加载和多线程安全。
        return SingletonHolder.mInstance;
    }

    private static class SingletonHolder{
        private static final Singleton4 mInstance = new Singleton4();
    }
}
