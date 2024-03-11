package com.codurance.training.usecase;

import com.codurance.training.entity.TaskList;
import com.codurance.training.usecase.command.*;
import com.codurance.training.usecase.inputPort.InputBoundary;
import com.codurance.training.usecase.ouputPort.OutputBoundary;
import com.codurance.training.usecase.ouputPort.OutputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseCaseInteractor {
    private Map<String, Command> commandMap;
    private final TaskList taskList;

    public UseCaseInteractor() {
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

    public OutputBoundary execute(InputBoundary inputCommand) {
        String commandLine = inputCommand.getInputCommand();
        String[] commandRest = commandLine.split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], new ErrorCommand());
        List<String> results;
        if(commandRest.length > 1){
            results = command.execute(commandRest[1]);
        }
        else{
            results = command.execute(commandLine);
        }
        return new OutputData(results);
    }
}
