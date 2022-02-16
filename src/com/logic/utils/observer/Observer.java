package com.logic.utils.observer;

public interface Observer {

    public void sub(Observable source);

    public void unsub(Observable source);

    public void update(String message);

}
