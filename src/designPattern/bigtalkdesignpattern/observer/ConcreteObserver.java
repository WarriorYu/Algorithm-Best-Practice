package designPattern.bigtalkdesignpattern.observer;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/7
 * Describe : 具体观察者
 */
public class ConcreteObserver extends Observer {
    public String name;
    public ConcreteSubject subject;
    public String observerState;


    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        observerState = subject.subjectState;
        System.out.println(String.format("观察者%s的新状态是%s", name, observerState));
    }
}
