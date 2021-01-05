package designPattern.bigtalkdesignpattern.factory.simple;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 乘法
 */
public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return numberA * numberB;
    }
}
