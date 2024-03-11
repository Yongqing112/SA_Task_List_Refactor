package com.codurance.training.interfaceAdapter.presenter;

import java.util.List;

public class CommandPresenter {
    private final List<String> results;

    public CommandPresenter(List<String> results){
        this.results = results;
    }

    public List<String> getResults(){
        return results;
    }
}
