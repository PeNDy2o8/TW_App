package com.example.twapp.Command;

import com.example.twapp.BaseActivity.HistoryLocation;
import com.example.twapp.Visitor.Visitor;

public class HistoryLocation_command extends Command{
    public HistoryLocation_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(HistoryLocation.class);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
