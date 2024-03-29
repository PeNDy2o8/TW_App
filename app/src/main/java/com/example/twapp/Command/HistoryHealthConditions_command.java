package com.example.twapp.Command;

import com.example.twapp.BaseActivity.HistoryHealthConditions;
import com.example.twapp.Visitor.Visitor;

public class HistoryHealthConditions_command extends Command{
    public HistoryHealthConditions_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(HistoryHealthConditions.class);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

