package designPattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/4/2
 * Describe : 枚举实现单例
 */
public enum IdGenerator2 {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGenerator2.INSTANCE.getId());
    }
}
