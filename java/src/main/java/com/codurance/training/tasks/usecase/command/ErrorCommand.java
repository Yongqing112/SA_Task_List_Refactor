package com.codurance.training.tasks.usecase.command;

import java.util.ArrayList;
import java.util.List;

public class ErrorCommand implements Command {

    private final List<String> results;

    public ErrorCommand(){
        this.results = new ArrayList<String>();
    }

    @Override
    public List<String> execute(String commandLine) {
        results.add("I don't know what the command \"" + commandLine + "\" is.");
        results.add("\r\n");
        return results;
    }
}
