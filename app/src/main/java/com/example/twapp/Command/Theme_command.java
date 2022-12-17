package com.example.twapp.Command;

import com.example.twapp.Theme.Theme;
import com.example.twapp.Visitor.Visitor;

public class Theme_command extends Command{
    public Theme_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(Theme.class);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
