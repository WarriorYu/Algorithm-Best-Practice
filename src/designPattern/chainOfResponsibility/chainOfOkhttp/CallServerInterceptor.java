package designPattern.chainOfResponsibility.chainOfOkhttp;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/8
 * Describe :
 */
public class CallServerInterceptor implements Interceptor {
    @Override
    public String intercept(Chain chain) {
//        String responce = chain.process("我是 CallServerInterceptor 处理的结果");
        return "处理结束 -- CallServerInterceptor -- intercept";

    }
}
