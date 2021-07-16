package designPattern.bigtalkdesignpattern.practice.factory;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/4/23
 * Describe :
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if (numB == 0) {
            throw new RuntimeException("除数不能为0");
        }
        return numA / numB;
    }
}
