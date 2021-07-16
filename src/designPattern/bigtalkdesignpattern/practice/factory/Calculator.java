package designPattern.bigtalkdesignpattern.practice.factory;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/4/23
 * Describe :
 */
public class Calculator {
    public static void main(String[] args) {
        char operator = '+';
        Operation operation = OperationFactory.createOperation(operator);
        operation.numA = 10;
        operation.numB = 100;
        double result = operation.getResult();
        System.out.println(result);
    }
}
