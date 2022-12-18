package com.example.twapp.Command;

import com.example.twapp.BaseActivity.AbnormalRecord;
import com.example.twapp.Visitor.Visitor;

public class AbnormalRecord_command extends Command{
    public AbnormalRecord_command(Receiver receiver){
        super(receiver);
    }
    @Override
    public void execute() {
        receiver.action(AbnormalRecord.class);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
