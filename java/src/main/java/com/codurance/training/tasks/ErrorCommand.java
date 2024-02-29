package com.codurance.training.tasks;

import java.io.PrintWriter;

public class ErrorCommand implements Command{

    private final PrintWriter out;

    public ErrorCommand(PrintWriter out){
        this.out = out;
    }

    @Override
    public void execute(String commandLine) {
        out.printf("I don't know what the command \"%s\" is.", commandLine);
        out.println();
    }
}
