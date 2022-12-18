package com.example.twapp.Command;

import com.example.twapp.Login.Logins;
import com.example.twapp.Visitor.Visitor;

public class Login_command extends Command{
    public Login_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(Logins.class);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
