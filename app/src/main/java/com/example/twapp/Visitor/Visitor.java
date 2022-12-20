package com.example.twapp.Visitor;

import com.example.twapp.Command.AbnormalRecord_command;
import com.example.twapp.Command.Changeicon_command;
import com.example.twapp.Command.CurrentLocation_command;
import com.example.twapp.Command.HealthConditions_command;
import com.example.twapp.Command.HistoryHealthConditions_command;
import com.example.twapp.Command.HistoryLocation_command;
import com.example.twapp.Command.Login_command;
import com.example.twapp.Command.RingChange_command;
import com.example.twapp.Command.Setting_command;

public interface Visitor {

    public void visit(AbnormalRecord_command abnormalRecord);
    public void visit(Changeicon_command changeicon);
    public void visit(CurrentLocation_command currentLocation);
    public void visit(HealthConditions_command healthCondition);
    public void visit(HistoryHealthConditions_command historyHealthConditions);
    public void visit(HistoryLocation_command historyLocation);
    public void visit(Login_command login);
    public void visit(RingChange_command ringChange);
    public void visit(Setting_command setting);
}


