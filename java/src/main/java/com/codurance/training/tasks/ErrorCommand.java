package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ErrorCommand implements Command{

    private final PrintWriter out = Output.getInstance().output();

    public ErrorCommand(){

    }

    @Override
    public void execute(String commandLine, Map<String, List<Task>> projects) {
        out.printf("I don't know what the command \"%s\" is.", commandLine);
        out.println();
    }
}
