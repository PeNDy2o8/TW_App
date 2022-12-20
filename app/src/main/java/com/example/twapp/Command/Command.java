package com.example.twapp.Command;

import com.example.twapp.Visitor.Visitor;

public abstract class Command {
    protected Receiver receiver;
    public Command(Receiver receiver){
        this.receiver = receiver;
    }
    public abstract void execute();
    public abstract void accept(Visitor visitor);
}

