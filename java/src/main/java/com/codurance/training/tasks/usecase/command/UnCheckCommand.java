package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnCheckCommand implements Command {
    private final TaskList taskList;
    private final List<String> results;

    public UnCheckCommand(TaskList taskList){
        this.taskList = taskList;
        this.results = new ArrayList<String>();
    }

    @Override
    public List<String> execute(String idString) {
        setDone(idString, false, taskList);
        return results;
    }

    private Task findTask(int id, Map.Entry<String, List<Task>> project){
        for (Task task : project.getValue()) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private void setDone(String idString, boolean done, TaskList taskList) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : taskList.getTaskList().entrySet()) {
            Task task = findTask(id, project);
            if(task != null){
                task.setDone(done);
                return;
            }
        }
        results.add("Could not find a task with an ID of " + id + ".");
        results.add("\r\n");
    }
}