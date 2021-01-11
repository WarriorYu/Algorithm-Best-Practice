package androiddesignpattern.singleton;

import java.io.ObjectStreamException;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/11
 * Describe : 单例  双重校验-锁 （Double check lock)
 *
 *   mInstance = new Singleton3();这行代码看起来是一行代码，但并不是原子操作。这行代码会被编译成多条汇编指令。它大致做了3个事情：
 *     1. 给Singleton3的实例分配内存；
 *     2. 调用Singleton3()的构造函数，初始化成员字段。
 *     3. 将mInstance对象指向分配的内存空间（此时mInstance就不是null了）。
 *
 *     由于JMM（java内存模型）中的Cache、寄存器到主内存回写顺序的规定，上面的2、3的执行循序是不确定的，可能是1-2-3，也可能是1-3-2；在JDK1.5
 *     之后，调整了jvm，具体化了volatile关键字。只要将mInstance使用volatile修饰，就可以保证mInstance每次都从主内存中读取。
 */
public class Singleton3 {

    private Singleton3() {

    }

    // volatile :禁止指令重排
    private volatile static Singleton3 mInstance;

    public static Singleton3 getInstance() {
        if (mInstance == null) {
            synchronized (Singleton3.class) {
                if (mInstance == null) {
                    mInstance = new Singleton3();
                }
            }
        }
        return mInstance;
    }

    /**
     * 反序列化依然可以通过特殊的途径去创建类的一个新的实例，相当于调用了该类的构造方法。反序列化操作提供了一个很特别的钩子函数，类中具有
     * 一个私有的、被实例化的方法readResolve(),这个方法可以让开发人员控制对象的反序列化。
     * 加入如下方法就可以杜绝单例对象在被反序列化时重新生成对象。
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return mInstance;
    }
}
