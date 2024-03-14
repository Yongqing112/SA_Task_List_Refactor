package com.codurance.training.tasks.usecase.command;

import java.util.ArrayList;
import java.util.List;

public class ErrorCommand implements Command {


    public ErrorCommand(){
    }

    @Override
    public List<String> execute(String commandLine) {
        List<String> results = new ArrayList<>();
        results.add("I don't know what the command \"" + commandLine + "\" is.");
        results.add("\r\n");
        return results;
    }
}
