package com.codurance.training.tasks.interfaceAdapter.interfaceAdapter.presenter;

import com.codurance.training.tasks.usecase.ouputPort.OutputBoundary;

import java.util.List;

public class CommandPresenter {
    private final OutputBoundary outputData;

    public CommandPresenter(OutputBoundary outputData){
        this.outputData = outputData;
    }

    public List<String> getResults(){
        return this.outputData.getResults();
    }
}
