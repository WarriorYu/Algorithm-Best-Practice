package designPattern.bigtalkdesignpattern.factory.simple;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 使用工厂方法生成实例完成运算操作
 */
public class Calculator {
    public static void main(String[] args) {
        char operator = '+';
        Operation operation = OperationFactory.createOperation(operator);
        operation.numberA = 1.2;
        operation.numberB = 3.3;
        double result = operation.getResult();
        System.out.println(result);
    }
}
