package designPattern.chainOfResponsibility.chainOfOkhttp;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/8
 * Describe :
 */
public class BridgeInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
        String responce = chain.process("我是 BridgeInterceptor 处理的结果");
        return responce + " -- BridgeInterceptorce -- intercept";
    }
}
