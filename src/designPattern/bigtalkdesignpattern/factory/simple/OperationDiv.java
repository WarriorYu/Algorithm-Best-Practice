package designPattern.bigtalkdesignpattern.factory.simple;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 除法
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if (numberB == 0) {
            throw new RuntimeException("除数不能为0");
        }
        return numberA / numberB;
    }
}
