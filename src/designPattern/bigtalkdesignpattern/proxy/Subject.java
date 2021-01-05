package designPattern.bigtalkdesignpattern.proxy;

import exam.Son;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/12/29
 * Describe : 定义了RealSubject和Proxy的共用接口，这样在任何使用RealSubject
 * 的地方都可以使用Proxy
 */
public abstract class Subject {
    public abstract void request();
}
