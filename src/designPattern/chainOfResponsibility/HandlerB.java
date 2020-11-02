package designPattern.chainOfResponsibility;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/4
 * Describe :
 */
public class HandlerB extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        //...
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
