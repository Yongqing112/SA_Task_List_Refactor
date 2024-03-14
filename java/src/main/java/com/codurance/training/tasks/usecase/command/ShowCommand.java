package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowCommand implements Command {
    private final TaskList taskList;
    public ShowCommand(TaskList taskList){
        this.taskList = taskList;
    }

    private void displayTask(List<Task> taskList, List<String> results){
        for (Task task : taskList) {
            char done = task.isDone() ? 'x' : ' ';
            results.add("    ["+ done + "] " + task.getId() + ": " + task.getDescription() + "\r\n");
        }
    }
    @Override
    public List<String> execute(String arg) {
        List<String> results = new ArrayList<>();
        for (Map.Entry<String, List<Task>> project : taskList.getTaskList().entrySet()) {
            results.add(project.getKey() + "\r\n");
            displayTask(project.getValue(), results);
            results.add("\r\n");
        }
        return results;
    }
}
