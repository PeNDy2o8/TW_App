package com.example.twapp.Visitor;

import com.example.twapp.Command.AbnormalRecord_command;
import com.example.twapp.Command.Changeicon_command;
import com.example.twapp.Command.CurrentLocation_command;
import com.example.twapp.Command.HealthConditions_command;
import com.example.twapp.Command.HistoryHealthConditions_command;
import com.example.twapp.Command.HistoryLocation_command;
import com.example.twapp.Command.Invoker;
import com.example.twapp.Command.Light_sw_command;
import com.example.twapp.Command.Login_command;
import com.example.twapp.Command.Notify_command;
import com.example.twapp.Command.RingChange_command;
import com.example.twapp.Command.Setting_command;
import com.example.twapp.Command.Theme_command;

public class LoggedIn extends Invoker implements Visitor{

    @Override
    public void visit(AbnormalRecord_command abnormalRecord) {
        abnormalRecord.execute();
    }

    @Override
    public void visit(Changeicon_command changeicon) {
        changeicon.execute();
    }

    @Override
    public void visit(CurrentLocation_command currentLocation) {
        currentLocation.execute();
    }

    @Override
    public void visit(HealthConditions_command healthCondition) {
        healthCondition.execute();
    }

    @Override
    public void visit(HistoryHealthConditions_command historyHealthConditions) {
        historyHealthConditions.execute();
    }

    @Override
    public void visit(HistoryLocation_command historyLocation) {
        historyLocation.execute();
    }

    @Override
    public void visit(Light_sw_command lightSwitch) {
        lightSwitch.execute();
    }

    @Override
    public void visit(Login_command login) {
        login.execute();
    }

    @Override
    public void visit(Notify_command notify) {
        notify.execute();
    }

    @Override
    public void visit(RingChange_command ringChange) {
        ringChange.execute();
    }

    @Override
    public void visit(Setting_command setting) {
        setting.execute();
    }

    @Override
    public void visit(Theme_command theme) {
        theme.execute();
    }
}
