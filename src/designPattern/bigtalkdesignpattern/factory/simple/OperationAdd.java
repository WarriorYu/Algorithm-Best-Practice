package designPattern.bigtalkdesignpattern.factory.simple;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/24
 * Describe : 加法
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return numberA + numberB;
    }
}
