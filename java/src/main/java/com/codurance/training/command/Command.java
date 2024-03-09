package com.codurance.training.command;

import java.util.List;

public interface Command {
    List<String> execute(String command);
}
