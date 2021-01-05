package designPattern.bigtalkdesignpattern.builder;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/5
 * Describe : 用来指挥建造过程
 */
public class Director {

    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
