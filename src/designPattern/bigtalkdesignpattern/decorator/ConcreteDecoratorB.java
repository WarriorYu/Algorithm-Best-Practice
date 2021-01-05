package designPattern.bigtalkdesignpattern.decorator;

import designPattern.bigtalkdesignpattern.factory.simple.Operation;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/29
 * Describe :
 */
public class ConcreteDecoratorB extends Decorator {

    @Override
    public void operation() {
        // 首先运行原 Component 的 operation(),再执行本类的功能，如addedBehavior(),
        // 相当于对原Component进行了装饰
        super.operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");

    }

    // 本类独有的方法，以区别于ConcreteDecorator
    private void addedBehavior() {

    }
}
