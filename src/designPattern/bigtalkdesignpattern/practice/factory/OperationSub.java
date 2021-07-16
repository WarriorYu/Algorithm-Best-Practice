package designPattern.bigtalkdesignpattern.practice.factory;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/4/23
 * Describe :
 */
public class OperationSub extends Operation{

    @Override
    public double getResult() {
        return numA - numB;
    }
}
