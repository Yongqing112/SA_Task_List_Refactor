package com.codurance.training.usecase.inputPort;

public class InputData implements InputBoundary{
    private final String inputCommand;

    public InputData(String inputCommand){
        this.inputCommand = inputCommand;
    }
    @Override
    public String getInputCommand(){
        return inputCommand;
    }
}
