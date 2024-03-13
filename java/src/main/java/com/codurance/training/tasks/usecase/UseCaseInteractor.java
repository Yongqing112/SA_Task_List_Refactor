package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.command.*;
import com.codurance.training.tasks.usecase.ouputPort.OutputBoundary;
import com.codurance.training.tasks.usecase.inputPort.InputBoundary;
import com.codurance.training.tasks.usecase.ouputPort.OutputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseCaseInteractor {
    private Map<String, Command> commandMap;
    private final TaskList taskList;
    private List<String> outputData;

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

    public void executeCommand(InputBoundary inputCommand) {
        String commandLine = inputCommand.getInputCommand();
        String[] commandRest = commandLine.split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], new ErrorCommand());

        if(commandRest.length > 1){
            outputData = command.execute(commandRest[1]);
        }
        else{
            outputData = command.execute(commandLine);
        }
    }

    public OutputBoundary getOutputData(){
        return new OutputData(outputData);
    }
}
