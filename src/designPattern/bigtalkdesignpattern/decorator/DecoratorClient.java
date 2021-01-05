package designPattern.bigtalkdesignpattern.decorator;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/29
 * Describe : 客户端代码。
 */
public class DecoratorClient {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        // 装饰的方法是：首先用ConcreteComponent实例化对象c，然后用d1来包装c,
        //再用d2包装d1，最终执行d2的operation()。
        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();

        // 在这里，装饰模式是利用setComponent()来对对象进行包装的。这样每个装饰对象的实现就和
        // 如何使用这个对象分离开了，每个装饰对象只关心自己的功能，不用关心如何被添加到对象链当中


    }
}
