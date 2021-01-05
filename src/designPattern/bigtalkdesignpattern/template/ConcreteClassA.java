package designPattern.bigtalkdesignpattern.template;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe :
 */
public class ConcreteClassA extends AbstractClass {
    @Override
    public void primitiveOperation1() {
        System.out.println("具体类A的方法1实现");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("具体类A的方法2实现");
    }
}
