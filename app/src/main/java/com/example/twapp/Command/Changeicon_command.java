package com.example.twapp.Command;

import com.example.twapp.ChangeIcon.ChooseiconActivity;
import com.example.twapp.Visitor.Visitor;

public class Changeicon_command extends Command{
    public Changeicon_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(ChooseiconActivity.class);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
