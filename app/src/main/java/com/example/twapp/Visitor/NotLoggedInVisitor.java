package com.example.twapp.Visitor;

import com.example.twapp.Command.AbnormalRecord_command;
import com.example.twapp.Command.Changeicon_command;
import com.example.twapp.Command.CurrentLocation_command;
import com.example.twapp.Command.HealthConditions_command;
import com.example.twapp.Command.HistoryHealthConditions_command;
import com.example.twapp.Command.HistoryLocation_command;
import com.example.twapp.Command.Login_command;
import com.example.twapp.Command.Receiver;
import com.example.twapp.Command.RingChange_command;
import com.example.twapp.Command.Setting_command;

public class NotLoggedInVisitor implements Visitor{

    public NotLoggedInVisitor(Receiver receiver){
        login=new Login_command(receiver);
    }
    private Login_command login ;
    @Override
    public void visit(AbnormalRecord_command abnormalRecord) {
        login.execute();
    }
    @Override
    public void visit(Changeicon_command changeicon) {
        login.execute();
    }
    @Override
    public void visit(CurrentLocation_command currentLocation) {
        login.execute();
    }
    @Override
    public void visit(HealthConditions_command healthCondition) {
        login.execute();
    }
    @Override
    public void visit(HistoryHealthConditions_command historyHealthConditions) {
        login.execute();
    }
    @Override
    public void visit(HistoryLocation_command historyLocation) {
        login.execute();
    }
    @Override
    public void visit(Login_command login) {
        login.execute();
    }
    @Override
    public void visit(RingChange_command ringChange) {
        login.execute();
    }
    @Override
    public void visit(Setting_command setting) {
        login.execute();
    }
}

