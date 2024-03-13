package com.codurance.training.interfaceAdapter.presenter;

import com.codurance.training.usecase.UseCaseInteractor;

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
