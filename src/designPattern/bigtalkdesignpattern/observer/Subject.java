package designPattern.bigtalkdesignpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/1/7
 * Describe : 抽象观察者（后者叫主题）。可以添加、删除观察者
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
