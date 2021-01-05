package designPattern.bigtalkdesignpattern.factory.simple;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 简单运算工厂类
 */
public class OperationFactory {
    public static Operation createOperation(char operator) {
        Operation operation = null;
        switch (operator) {
            case '+':
                operation = new OperationAdd();
                break;
            case '-':
                operation = new OperationSub();
                break;
            case '*':
                operation = new OperationMul();
                break;
            case '/':
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}
