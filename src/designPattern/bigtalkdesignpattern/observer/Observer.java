package designPattern.bigtalkdesignpattern.observer;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/7
 * Describe : 抽象观察者，为所有的具体观察者定义一个接口，当得到主题的通知时更新自己
 */
public abstract class Observer {

    public abstract void update();
}
