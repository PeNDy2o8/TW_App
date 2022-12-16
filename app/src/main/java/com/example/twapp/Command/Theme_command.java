package com.example.twapp.Command;

import com.example.twapp.Theme.Theme;

public class Theme_command extends Command{
    public Theme_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(Theme.class);
    }
}
