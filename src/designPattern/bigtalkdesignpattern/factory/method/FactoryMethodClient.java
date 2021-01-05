package designPattern.bigtalkdesignpattern.factory.method;

import designPattern.bigtalkdesignpattern.factory.simple.Operation;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/4
 * Describe : 工厂方法
 */
public class FactoryMethodClient {
    public static void main(String[] args) {
        AddFactory addFactory = new AddFactory();
        Operation operation = addFactory.createOperation();
        operation.numberA = 1;
        operation.numberB = 2;
        operation.getResult();
    }
}
