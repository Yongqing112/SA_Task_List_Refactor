package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckCommand implements Command {

    private final TaskList taskList;

    public CheckCommand(TaskList taskList){
        this.taskList = taskList;
    }

    @Override
    public List<String> execute(String idString) {
        return setDone(idString, true, taskList);
    }

    private Task findTask(int id, Map.Entry<String, List<Task>> project){
        for (Task task : project.getValue()) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private List<String> setDone(String idString, boolean done, TaskList taskList) {
        int id = Integer.parseInt(idString);
        List<String> results = new ArrayList<>();
        for (Map.Entry<String, List<Task>> project : taskList.getTaskList().entrySet()) {
            Task task = findTask(id, project);
            if(task != null){
                task.setDone(done);
                return results;
            }
        }
        results.add("Could not find a task with an ID of " + id + ".");
        results.add("\r\n");
        return results;
    }
}
