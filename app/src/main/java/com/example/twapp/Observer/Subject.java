package com.example.twapp.Observer;

public interface Subject {
    void attach(Observer observer);
    void notifyObservers();

}
