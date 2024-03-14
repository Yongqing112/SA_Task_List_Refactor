package com.codurance.training.tasks.usecase.command;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements Command {
    public HelpCommand(){
    }

    @Override
    public List<String> execute(String[] subcommandRest) {
        List<String> results = new ArrayList<>();
        results.add("Commands:\r\n");
        results.add("  show\r\n");
        results.add("  add project <project name>\r\n");
        results.add("  add task <project name> <task description>\r\n");
        results.add("  check <task ID>\r\n");
        results.add("  uncheck <task ID>\r\n");
        results.add("\r\n");
        return results;
    }
}
