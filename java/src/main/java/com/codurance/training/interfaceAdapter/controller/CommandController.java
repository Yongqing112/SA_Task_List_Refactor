package com.codurance.training.interfaceAdapter.controller;

import com.codurance.training.usecase.UseCaseInteractor;
import com.codurance.training.usecase.inputPort.InputBoundary;
import com.codurance.training.usecase.inputPort.InputData;

public class CommandController {
    private final UseCaseInteractor useCaseInteractor;

    public CommandController(UseCaseInteractor useCaseInteractor){
        this.useCaseInteractor = useCaseInteractor;
    }


    public void executeController(String commandLine){
        InputBoundary inputCommand = new InputData(commandLine);
        useCaseInteractor.executeCommand(inputCommand);
    }
}
