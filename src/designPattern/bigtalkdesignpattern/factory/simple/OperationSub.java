package designPattern.bigtalkdesignpattern.factory.simple;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 减法
 */
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        return numberA - numberB;
    }
}
