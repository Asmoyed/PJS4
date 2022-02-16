package com.logic.utils.observer;

import java.util.ArrayList;

public class Observable {
    private ArrayList<Observer> subscribers;

    public Observable() {
        subscribers = new ArrayList<>();
    }

    public void addSub(Observer observer) {subscribers.add(observer);}

    public void removeSub(Observer observer) {subscribers.remove(observer);}

    public void notify(String message) {
        for (int i = 0; i < subscribers.size(); i++) {
            subscribers.get(i).update(message);
        }
    }
}
