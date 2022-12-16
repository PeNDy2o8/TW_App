package com.example.twapp.Command;

import com.example.twapp.Login.Logins;

public class Login_command extends Command{
    public Login_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(Logins.class);
    }
}
