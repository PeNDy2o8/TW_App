package com.example.twapp.Command;

import com.example.twapp.BaseActivity.HealthConditions;
import com.example.twapp.Visitor.Visitor;

public class HealthConditions_command extends Command{
    public HealthConditions_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(HealthConditions.class);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
