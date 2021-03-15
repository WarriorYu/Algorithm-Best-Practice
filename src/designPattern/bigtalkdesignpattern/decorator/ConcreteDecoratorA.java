package designPattern.bigtalkdesignpattern.decorator;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/29
 * Describe :
 */
public class ConcreteDecoratorA extends Decorator {

    // 本类独有的功能，以区别于ConcreteDecoratorB
    private String addedState;

    @Override
    public void operation() {
        // 首先运行原 Component 的 operation(),再执行本类的功能，如addedState,
        // 相当于对原Component进行了装饰
        super.operation();
        addedState = "New State";
        System.out.println("具体装饰对象A的操作");
    }
}
