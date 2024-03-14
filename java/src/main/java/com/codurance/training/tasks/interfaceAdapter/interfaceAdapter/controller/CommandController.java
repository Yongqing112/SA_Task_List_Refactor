package com.codurance.training.tasks.interfaceAdapter.interfaceAdapter.controller;

import com.codurance.training.tasks.usecase.UseCaseInteractor;
import com.codurance.training.tasks.usecase.inputPort.InputBoundary;
import com.codurance.training.tasks.usecase.inputPort.InputData;
import com.codurance.training.tasks.usecase.ouputPort.OutputBoundary;

public class CommandController {
    private final UseCaseInteractor useCaseInteractor;

    public CommandController(UseCaseInteractor useCaseInteractor){
        this.useCaseInteractor = useCaseInteractor;
    }


    public OutputBoundary executeController(String commandLine){
        InputBoundary inputCommand = new InputData(commandLine);
        return useCaseInteractor.executeCommand(inputCommand);
    }
}
