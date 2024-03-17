package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.Project;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.inputPort.InputBoundary;

import java.util.ArrayList;
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

    private Task findTask(int id, Project project){
        for (Task task : project.getTasks()) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private List<String> setDone(String idString, boolean done, TaskList taskList) {
        int id = Integer.parseInt(idString);
        List<String> results = new ArrayList<>();
        for (Project project : taskList.getTasks().getProject()) {
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
