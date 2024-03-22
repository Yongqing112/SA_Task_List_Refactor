package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.*;
import com.codurance.training.tasks.usecase.inputPort.InputBoundary;

import java.util.ArrayList;
import java.util.List;

public class AddCommand implements Command {
    private final TaskList taskList;

    public AddCommand(TaskList taskList){
        this.taskList = taskList;
    }

    @Override
    public List<String> execute(InputBoundary inputSubcommand) {
        String[] subcommandRest = inputSubcommand.getInputCommand();
        String subcommand = subcommandRest[0];
        List<String> results = new ArrayList<>();
        if (subcommand.equals("project")) {
            addProject(ProjectName.of(subcommandRest[1]));
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(ProjectName.of(projectTask[0]), projectTask[1], results);
        }
        return results;
    }

    private void addProject(ProjectName projectName) {
        taskList.addProject(projectName, new ArrayList<>());
    }

    private boolean isProjectExist(ProjectName projectName){
        return taskList.containsKey(projectName);
    }

    private void addTask(ProjectName projectName, String description, List<String> results) {
        if (!isProjectExist(projectName)) {
            results.add("Could not find a project with the name \"" + projectName + "\".");
            results.add("\r\n");
            return;
        }
        taskList.addTask(projectName, new Task(taskList.nextId(), description, false));
    }
}
