package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class HelpCommand implements Command{

    private final PrintWriter out = Output.getInstance().output();

    public HelpCommand(){
    }

    @Override
    public void execute(String arg, Map<String, List<Task>> projects) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
}
