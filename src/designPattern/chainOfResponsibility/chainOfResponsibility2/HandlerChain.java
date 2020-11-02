package designPattern.chainOfResponsibility.chainOfResponsibility2;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/8
 * Describe :
 */
public class HandlerChain {
    private IHandler head;
    private IHandler tail;
    public void addHandler(IHandler handler) {
        handler.setSuccessor(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        head.handle();
    }
}
