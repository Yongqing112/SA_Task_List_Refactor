package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.inputPort.InputBoundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private Task findTask(int id, Map.Entry<ProjectName, List<Task>> project){
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
        for (Map.Entry<ProjectName, List<Task>> project : taskList.getTasks().entrySet()) {
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
