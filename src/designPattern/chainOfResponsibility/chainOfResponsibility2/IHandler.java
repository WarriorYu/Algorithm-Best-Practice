package designPattern.chainOfResponsibility.chainOfResponsibility2;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/8
 * Describe :
 */
public abstract class IHandler {
    private IHandler mSuccessor;

    public void setSuccessor(IHandler handler) {
        this.mSuccessor = handler;
    }

    public boolean handle() {
        boolean isHandle = doHandle();
        if (mSuccessor != null && !isHandle) {
            mSuccessor.handle();
        }
        return isHandle;
    }

    protected abstract boolean doHandle();
}
