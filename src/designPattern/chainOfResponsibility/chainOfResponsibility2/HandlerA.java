package designPattern.chainOfResponsibility.chainOfResponsibility2;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/8
 * Describe :
 */
public class HandlerA extends IHandler {
    @Override
    protected boolean doHandle() {
        boolean isHandle = false;
        System.out.println("HandlerA执行了doHandle");
        return isHandle;
    }
}
