package com.codurance.training.interfaceAdapter.presenter;

import com.codurance.training.usecase.ouputPort.OutputBoundary;

import java.util.List;

public class CommandPresenter {
    private final OutputBoundary results;

    public CommandPresenter(OutputBoundary results){
        this.results = results;
    }

    public List<String> getResults(){
        return results.getResults();
    }
}
