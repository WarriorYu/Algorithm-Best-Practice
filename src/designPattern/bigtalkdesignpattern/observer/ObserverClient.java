package designPattern.bigtalkdesignpattern.observer;

import javafx.scene.input.DataFormat;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/7
 * Describe : 观察者模式
 */
public class ObserverClient {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver(subject, "X"));
        subject.attach(new ConcreteObserver(subject, "Y"));
        subject.attach(new ConcreteObserver(subject, "Z"));

        subject.subjectState = "ABC";

        subject.notifyObservers();

    }
}
