package designPattern.bigtalkdesignpattern.practice.factory;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/4/23
 * Describe :
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
