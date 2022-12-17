package com.example.twapp.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    protected List<Command> commandList = new ArrayList<>();
    public void addCommand(Command command){
        commandList.add(command);
    }
    public void executeCommand(){
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}
