package com.codurance.training.tasks.interfaceAdapter.interfaceAdapter.presenter;

import com.codurance.training.tasks.usecase.UseCaseInteractor;

import java.util.List;

public class CommandPresenter {
    private final UseCaseInteractor useCaseInteractor;

    public CommandPresenter(UseCaseInteractor useCaseInteractor){
        this.useCaseInteractor = useCaseInteractor;
    }

    public List<String> getResults(){
        return useCaseInteractor.getOutputData().getResults();
    }
}
