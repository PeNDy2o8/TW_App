package com.example.twapp.Visitor;

import com.example.twapp.Command.AbnormalRecord_command;
import com.example.twapp.Command.Changeicon_command;
import com.example.twapp.Command.CurrentLocation_command;
import com.example.twapp.Command.HealthConditions_command;
import com.example.twapp.Command.HistoryHealthConditions_command;
import com.example.twapp.Command.HistoryLocation_command;
import com.example.twapp.Command.Light_sw_command;
import com.example.twapp.Command.Login_command;
import com.example.twapp.Command.Notify_command;
import com.example.twapp.Command.Receiver;
import com.example.twapp.Command.RingChange_command;
import com.example.twapp.Command.Setting_command;
import com.example.twapp.Command.Theme_command;

public class NotLoggedInVisitor implements Visitor{

    public NotLoggedInVisitor(Receiver receiver){
        login=new Login_command(receiver);
    }
    Login_command login ;
    @Override
    public void visit(AbnormalRecord_command abnormalRecord) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(Changeicon_command changeicon) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(CurrentLocation_command currentLocation) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(HealthConditions_command healthCondition) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(HistoryHealthConditions_command historyHealthConditions) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(HistoryLocation_command historyLocation) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(Light_sw_command lightSwitch) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(Login_command login) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(Notify_command notify) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(RingChange_command ringChange) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(Setting_command setting) {
        System.out.println("Please login first");
        login.execute();
    }

    @Override
    public void visit(Theme_command theme) {
        System.out.println("Please login first");
        login.execute();
    }


}
