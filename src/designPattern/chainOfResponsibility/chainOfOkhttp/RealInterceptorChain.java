package designPattern.chainOfResponsibility.chainOfOkhttp;

import java.util.List;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/8
 * Describe : 模拟OKhttp的责任链模式
 */
public class RealInterceptorChain implements Interceptor.Chain {
    private final int index;
    private final List<Interceptor> interceptors;

    public RealInterceptorChain(List<Interceptor> interceptors, int index) {
        this.interceptors = interceptors;
        this.index = index;
    }

    @Override
    public String process(String request) {
        System.out.println("处理前 -- " + request);
        RealInterceptorChain next = new RealInterceptorChain(interceptors, index + 1);
        Interceptor interceptor = interceptors.get(index);
        String response = interceptor.intercept(next);
        System.out.println("处理后" + response);
        return response;
    }
}
