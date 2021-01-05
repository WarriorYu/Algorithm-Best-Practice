package designPattern.bigtalkdesignpattern.factory.simple;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 运算类
 */
public abstract class Operation {

    public double numberA;
    public double numberB;

    public abstract double getResult();
}
