package com.codurance.training.tasks.interfaceAdapter.interfaceAdapter.controller;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.command.*;
import com.codurance.training.tasks.usecase.ouputPort.OutputBoundary;
import com.codurance.training.tasks.usecase.ouputPort.OutputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandController {
    private Map<String, Command> commandMap;
    private final TaskList taskList;

    public CommandController(){
        this.taskList = new TaskList();
        initializeCommandMap();
    }

    private void initializeCommandMap() {
        commandMap = new HashMap<>();
        commandMap.put("show", new ShowCommand(taskList));
        commandMap.put("add", new AddCommand(taskList));
        commandMap.put("check", new CheckCommand(taskList));
        commandMap.put("uncheck", new UnCheckCommand(taskList));
        commandMap.put("help", new HelpCommand());
    }

    public OutputBoundary executeController(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], new ErrorCommand());

        List<String> outputData;
        if(commandRest.length > 1){
            String[] subcommandRest = commandRest[1].split(" ", 2);
            outputData = command.execute(subcommandRest);
        }
        else{
            outputData = command.execute(commandRest);
        }
        return new OutputData(outputData);
    }
}
