package com.codurance.training.tasks.usecase.command;

import java.util.ArrayList;
import java.util.List;

public class ErrorCommand implements Command {


    public ErrorCommand(){
    }

    @Override
    public List<String> execute(String[] commandRest) {
        List<String> results = new ArrayList<>();
        results.add("I don't know what the command \"" + commandRest[0] + "\" is.");
        results.add("\r\n");
        return results;
    }
}
