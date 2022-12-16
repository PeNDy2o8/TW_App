package com.example.twapp.Command;

import com.example.twapp.BaseActivity.AbnormalRecord;

public class AbnormalRecord_command extends Command{
    public AbnormalRecord_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(AbnormalRecord.class);
    }
}
