package designPattern.bigtalkdesignpattern.practice.observer;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/4/23
 * Describe :
 */
public class ObserverClient {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        subject.attach(new ConcreteObserver(subject, "X"));
        subject.attach(new ConcreteObserver(subject,"Y"));
        subject.attach(new ConcreteObserver(subject,"Z"));
        subject.subjectState = "哈哈哈";
        subject.notifyObservers();



    }
}
