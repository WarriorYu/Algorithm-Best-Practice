package designPattern.bigtalkdesignpattern.builder;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : 建造者模式：是在当创建复杂对象的算法应该独立于该对象的组成部分以及他们的装配方式时适用的模式。
 */
public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director();

        ConcreteBuilder1 builder1 = new ConcreteBuilder1();
        director.construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        ConcreteBuilder2 builder2 = new ConcreteBuilder2();
        director.construct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}
