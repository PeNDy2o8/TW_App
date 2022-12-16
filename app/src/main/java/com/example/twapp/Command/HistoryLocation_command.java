package com.example.twapp.Command;

import com.example.twapp.HistoryLocation;

public class HistoryLocation_command extends Command{
    public HistoryLocation_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(HistoryLocation.class);
    }
}
