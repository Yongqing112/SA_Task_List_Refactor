package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.inputPort.InputBoundary;

import java.util.List;

public class UnCheckCommand implements Command {
    private final TaskList taskList;
    public UnCheckCommand(TaskList taskList){
        this.taskList = taskList;
    }

    @Override
    public List<String> execute(InputBoundary inputSubcommand) {
        String[] idString = inputSubcommand.getInputCommand();
        return setDone(idString[0], false, taskList);
    }

    private List<String> setDone(String idString, boolean done, TaskList taskList) {
        return taskList.setDone(idString, done);
    }
}
