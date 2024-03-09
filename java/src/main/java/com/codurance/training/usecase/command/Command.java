package com.codurance.training.usecase.command;

import java.util.List;

public interface Command {
    List<String> execute(String command);
}
