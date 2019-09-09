package com.app.mode.observer;

public interface Subject<T> {
    void registerObserver(Observer<T> observer);

    void removeObserver(Observer<T> observer);


    void notifyObservers();
}
