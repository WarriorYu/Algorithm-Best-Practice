package designPattern.bigtalkdesignpattern.template;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : AbstractClass是抽象类，即抽象模板，定义并实现了一个模板方法。这个模板方法一般是一个具体方法，他给出了一个顶级的逻辑的骨架，
 * 而逻辑的组成步骤在相应的抽象操作中，推迟到子类实现。
 */
public abstract class AbstractClass {
    public abstract void primitiveOperation1();

    public abstract void primitiveOperation2();

    public void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        System.out.println("模板方法结束\n");
    }
}
