package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.usecase.inputPort.InputBoundary;

import java.util.List;

public interface Command {
    List<String> execute(InputBoundary subcommandRest);
}
