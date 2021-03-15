package designPattern.bigtalkdesignpattern.decorator;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/29
 * Describe : Decorator 装饰抽象类继承了Component，从外类来扩展Component类的功能，
 * 但是对于Component来说，是无需知道Decorator的存在的。
 */
public class Decorator extends Component {

    protected Component component;

    // 设置component
    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        // 重写operation(),实际执行的是Component的operation()
        if (component != null) {
            component.operation();
        }
    }
}
