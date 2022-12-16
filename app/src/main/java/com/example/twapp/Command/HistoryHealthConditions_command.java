package com.example.twapp.Command;

import com.example.twapp.HistoryHealthConditions;

public class HistoryHealthConditions_command extends Command{
    public HistoryHealthConditions_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(HistoryHealthConditions.class);
    }
}
