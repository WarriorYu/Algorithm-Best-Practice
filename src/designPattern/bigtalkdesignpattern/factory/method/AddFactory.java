package designPattern.bigtalkdesignpattern.factory.method;

import designPattern.bigtalkdesignpattern.factory.simple.Operation;
import designPattern.bigtalkdesignpattern.factory.simple.OperationAdd;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/4
 * Describe :
 */
public class AddFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
