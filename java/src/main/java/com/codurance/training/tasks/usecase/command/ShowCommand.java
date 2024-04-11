package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.Project;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.ProjectList;
import com.codurance.training.tasks.usecase.inputPort.InputBoundary;

import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command {
    private final ProjectList taskList;
    public ShowCommand(ProjectList taskList){
        this.taskList = taskList;
    }

    private void displayTask(List<Task> taskList, List<String> results){
        for (Task task : taskList) {
            char done = task.isDone() ? 'x' : ' ';
            results.add("    ["+ done + "] " + task.getId() + ": " + task.getDescription() + "\r\n");
        }
    }
    @Override
    public List<String> execute(InputBoundary inputSubcommand) {
        List<String> results = new ArrayList<>();
        for (Project project : taskList.getProjectList()) {
            results.add(project.getProjectName().name() + "\r\n");
            displayTask(project.getTasks(), results);
            results.add("\r\n");
        }
        return results;
    }
}
