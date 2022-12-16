package com.example.twapp.Command;

import com.example.twapp.HealthConditions;

public class HealthConditions_command extends Command{
    public HealthConditions_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(HealthConditions.class);
    }
}
