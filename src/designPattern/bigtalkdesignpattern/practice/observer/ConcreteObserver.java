package designPattern.bigtalkdesignpattern.practice.observer;


/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/4/23
 * Describe :
 */
public class ConcreteObserver extends Observer {
    private ConcreteSubject subject;
    private String name;

    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void upDate() {
        System.out.println(String.format("观察者%s的新状态是%s", subject.subjectState, name));
    }
}
