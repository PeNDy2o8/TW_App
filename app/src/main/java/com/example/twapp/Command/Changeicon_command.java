package com.example.twapp.Command;

import com.example.twapp.ChangeIcon.ChooseiconActivity;

public class Changeicon_command extends Command{
    public Changeicon_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(ChooseiconActivity.class);
    }
}
