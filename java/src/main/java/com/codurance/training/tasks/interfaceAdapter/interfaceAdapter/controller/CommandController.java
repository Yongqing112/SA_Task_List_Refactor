package com.codurance.training.tasks.interfaceAdapter.interfaceAdapter.controller;

import com.codurance.training.tasks.entity.ProjectList;
import com.codurance.training.tasks.entity.ProjectListId;
import com.codurance.training.tasks.usecase.command.*;
import com.codurance.training.tasks.usecase.inputPort.AddProjectInput;
import com.codurance.training.tasks.usecase.inputPort.AddTaskInput;
import com.codurance.training.tasks.usecase.inputPort.ErrorInput;
import com.codurance.training.tasks.usecase.inputPort.SetDoneInput;
import com.codurance.training.tasks.usecase.ouputPort.OutputBoundary;
import com.codurance.training.tasks.usecase.ouputPort.OutputData;

import java.util.ArrayList;
import java.util.List;

public class CommandController {
    private final ProjectList taskList;

    private static final ProjectListId DEFAULT_TO_DO_LIST_ID = ProjectListId.of("001");

    public CommandController(){
        this.taskList = new ProjectList(DEFAULT_TO_DO_LIST_ID);
    }

    public OutputBoundary executeController(String commandLine) {
        List<String> outputData = new ArrayList<>();
        String[] commandRest = commandLine.split(" ", 2);
        String[] subcommandRest;
        switch (commandRest[0]) {
            case "show":
                outputData = new ShowCommand(taskList).execute(null);
                break;
            case "add":
                subcommandRest = commandRest[1].split(" ", 2);
                if (subcommandRest[0].equals("project")) {
                    AddProjectInput input = new AddProjectInput();
                    input.projectName = subcommandRest[1];
                    outputData = new AddProjectUseCase(taskList).execute(input);
                }
                else if (subcommandRest[0].equals("task")) {
                    String[] projectTask = subcommandRest[1].split(" ", 2);
                    AddTaskInput input = new AddTaskInput();
                    input.projectName = projectTask[0];
                    input.description = projectTask[1];
                    outputData = new AddTaskUseCase(taskList).execute(input);
                }
                break;
            case "check":
                SetDoneInput checkInput = new SetDoneInput();
                checkInput.id = commandRest[1];
                checkInput.done = true;
                outputData = new SetDoneUseCase(taskList).execute(checkInput);
                break;
            case "uncheck":
                SetDoneInput uncheckInput = new SetDoneInput();
                uncheckInput.id = commandRest[1];
                uncheckInput.done = false;
                outputData = new SetDoneUseCase(taskList).execute(uncheckInput);
                break;
            case "help":
                outputData = new HelpCommand().execute(null);
                break;
            default:
                ErrorInput input = new ErrorInput();
                input.commandLine = commandLine;
                outputData = new ErrorCommand().execute(input);
                break;
        }
        return new OutputData(outputData);
    }

}
