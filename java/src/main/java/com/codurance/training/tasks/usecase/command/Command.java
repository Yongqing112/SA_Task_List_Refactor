package com.codurance.training.tasks.usecase.command;

import java.util.List;

public interface Command {
    List<String> execute(String[] subcommandRest);
}
