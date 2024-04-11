package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.usecase.inputPort.ErrorInput;

import java.util.ArrayList;
import java.util.List;

public class ErrorCommand {


    public ErrorCommand(){
    }

    public List<String> execute(ErrorInput input) {
        List<String> results = new ArrayList<>();
        results.add("I don't know what the command \"" + input.commandLine + "\" is.");
        results.add("\r\n");
        return results;
    }
}
