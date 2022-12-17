package com.example.twapp.Command;

import com.example.twapp.BaseActivity.MapsActivity;
import com.example.twapp.MainActivity;
import com.example.twapp.Visitor.Visitor;

public class CurrentLocation_command extends Command{
    public CurrentLocation_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {receiver.action(MapsActivity.class);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
