package com.example.twapp.Command;

import com.example.twapp.FontSize;

public class Setting_command extends Command{
    public Setting_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(FontSize.class);
    }
}
