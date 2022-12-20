package com.example.twapp.Command;

import com.example.twapp.Template.RingChange;
import com.example.twapp.Visitor.Visitor;

public class RingChange_command extends Command{
    public RingChange_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(RingChange.class);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

