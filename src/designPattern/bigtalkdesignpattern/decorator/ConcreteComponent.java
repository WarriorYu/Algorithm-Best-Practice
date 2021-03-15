package designPattern.bigtalkdesignpattern.decorator;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/29
 * Describe : ConcreteComponent 是定义了一个具体的对象，也可以给这个对象添加一些职责
 */
public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
