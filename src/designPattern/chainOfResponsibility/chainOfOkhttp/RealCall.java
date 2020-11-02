package designPattern.chainOfResponsibility.chainOfOkhttp;

import java.util.ArrayList;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/8
 * Describe :
 */
public class RealCall {
    public static void main(String[] args) {
        ArrayList<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new RetryAndFollowupInterceptor());
        interceptors.add(new CacheInterceptor());
        interceptors.add(new BridgeInterceptor());
        interceptors.add(new ConnectInterceptor());
        interceptors.add(new CallServerInterceptor());

        RealInterceptorChain chain = new RealInterceptorChain(interceptors, 0);
        String response = chain.process("开始处理");
        System.out.println(response);
    }
}
