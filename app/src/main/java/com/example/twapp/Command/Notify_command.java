package com.example.twapp.Command;

import com.example.twapp.Notify;
import com.example.twapp.Visitor.Visitor;

public class Notify_command extends Command{
    public Notify_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(Notify.class);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
