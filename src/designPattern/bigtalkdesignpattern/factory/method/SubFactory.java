package designPattern.bigtalkdesignpattern.factory.method;

import designPattern.bigtalkdesignpattern.factory.simple.Operation;
import designPattern.bigtalkdesignpattern.factory.simple.OperationAdd;
import designPattern.bigtalkdesignpattern.factory.simple.OperationSub;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/4
 * Describe :
 */
public class SubFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
