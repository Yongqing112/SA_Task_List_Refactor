package com.codurance.training.usecase.command;

import com.codurance.training.entity.Task;
import com.codurance.training.entity.TaskList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowCommand implements Command {
    private final TaskList taskList;
    private final List<String> results;

    public ShowCommand(TaskList taskList){
        this.taskList = taskList;
        this.results = new ArrayList<String>();
    }

    private void displayTask(List<Task> taskList){
        for (Task task : taskList) {
            char done = task.isDone() ? 'x' : ' ';
            results.add("    ["+ done + "] " + task.getId() + ": " + task.getDescription() + "\r\n");
        }
    }
    @Override
    public List<String> execute(String arg) {
        results.clear();
        for (Map.Entry<String, List<Task>> project : taskList.getTaskList().entrySet()) {
            results.add(project.getKey() + "\r\n");
            displayTask(project.getValue());
            results.add("\r\n");
        }
        return results;
    }
}
