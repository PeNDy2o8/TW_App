package com.example.twapp.Command;

import com.example.twapp.Template.RingChange;

public class RingChange_command extends Command{
    public RingChange_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(RingChange.class);
    }
}
