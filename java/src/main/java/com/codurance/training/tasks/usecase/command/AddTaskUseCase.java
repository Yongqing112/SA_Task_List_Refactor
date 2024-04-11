package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.*;
import com.codurance.training.tasks.usecase.inputPort.AddTaskInput;

import java.util.ArrayList;
import java.util.List;

public class AddTaskUseCase {
    private final ProjectList taskList;

    public AddTaskUseCase(ProjectList taskList){
        this.taskList = taskList;
    }

    public List<String> execute(AddTaskInput input) {
        return addTask(ProjectName.of(input.projectName), input.description);
    }

    private boolean isProjectExist(ProjectName projectName){
        return taskList.containsProject(projectName);
    }

    private List<String> addTask(ProjectName projectName, String description) {
        List<String> results = new ArrayList<>();
        if (!isProjectExist(projectName)) {
            results.add("Could not find a project with the name \"" + projectName.name() + "\".");
            results.add("\r\n");
            return results;
        }
        taskList.addTask(projectName, TaskId.of(taskList.nextId()), description, false);
        return results;
    }
}
