package com.example.twapp.Command;

import com.example.twapp.Notify;

public class Notify_command extends Command{
    public Notify_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(Notify.class);
    }
}
