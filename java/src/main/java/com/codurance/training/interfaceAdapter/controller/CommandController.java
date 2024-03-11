package com.codurance.training.interfaceAdapter.controller;

import com.codurance.training.usecase.UseCaseInteractor;
import com.codurance.training.usecase.inputPort.InputBoundary;
import com.codurance.training.usecase.inputPort.InputData;
import com.codurance.training.usecase.ouputPort.OutputBoundary;

public class CommandController {
    private OutputBoundary outputCommand;
    private final UseCaseInteractor useCaseInteractor;

    public CommandController(){
        useCaseInteractor = new UseCaseInteractor();
    }


    public void execute(String commandLine){
        InputBoundary inputCommand = new InputData(commandLine);
        outputCommand = useCaseInteractor.execute(inputCommand);
    }

    public OutputBoundary getResults(){
        return outputCommand;
    }
}
