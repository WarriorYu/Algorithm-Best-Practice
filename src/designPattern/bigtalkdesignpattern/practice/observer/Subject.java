package designPattern.bigtalkdesignpattern.practice.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2021/4/23
 * Describe : 被观察者
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();


    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).upDate();
        }
    }

}
