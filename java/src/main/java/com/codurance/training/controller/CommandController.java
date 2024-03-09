package com.codurance.training.controller;

import com.codurance.training.usecase.command.*;
import com.codurance.training.entity.TaskList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandController {
    private final TaskList taskList;
    private Map<String, Command> commandMap;
    private List<String> results;

    public CommandController(){
        this.taskList = new TaskList();
        initializeCommandMap();
    }

    private void initializeCommandMap() {
        commandMap = new HashMap<String, Command>();
        commandMap.put("show", new ShowCommand(taskList));
        commandMap.put("add", new AddCommand(taskList));
        commandMap.put("check", new CheckCommand(taskList));
        commandMap.put("uncheck", new UnCheckCommand(taskList));
        commandMap.put("help", new HelpCommand());
    }

    public void execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], new ErrorCommand());
        if(commandRest.length > 1){
            results = command.execute(commandRest[1]);
        }
        else{
            results = command.execute(commandLine);
        }
    }

    public List<String> getResults(){
        return results;
    }
}
