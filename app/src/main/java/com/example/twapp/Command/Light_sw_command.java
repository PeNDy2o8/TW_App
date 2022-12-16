package com.example.twapp.Command;

public class Light_sw_command extends Command{
    public Light_sw_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(Object.class);
    }
}
