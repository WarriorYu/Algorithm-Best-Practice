package designPattern;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/4/2
 * Describe : 单例设计模式 Sington Design Pattern
 */
public class IdGenerator {

    // 饿汉式
    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public long getId() {
        return id.incrementAndGet();
    }

//    private static final IdGenerator instance = new IdGenerator();
//    public static IdGenerator getInstance() {
//        return instance;
//    }

    //懒汉式
//    private static IdGenerator instance;
//    public static synchronized IdGenerator getInstance() {
//        if (instance == null) {
//            instance = new IdGenerator();
//        }
//        return instance;
//    }

    //懒汉式（双重检测）
//    private static IdGenerator instance;
//
//    public static IdGenerator getInstance() {
//        if (instance == null) {
//            synchronized (IdGenerator.class) { //这里是类级别的锁
//                if (instance == null) {
//                    instance = new IdGenerator();
//                }
//            }
//        }
//        return instance;
//    }

    //静态内部类
    private static class SingleHolder{
        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return SingleHolder.instance;
    }




    public static void main(String[] args) {
        long id = IdGenerator.getInstance().getId();
        System.out.println(id);
    }
}
