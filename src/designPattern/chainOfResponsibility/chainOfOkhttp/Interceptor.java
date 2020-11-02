package designPattern.chainOfResponsibility.chainOfOkhttp;

import com.sun.tools.javac.util.StringUtils;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/8
 * Describe :
 */
public interface Interceptor {
    String intercept(Chain chain);

    interface Chain {
        String process(String request);
    }
}
