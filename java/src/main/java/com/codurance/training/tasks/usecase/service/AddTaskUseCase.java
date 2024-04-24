package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.*;
import com.codurance.training.tasks.usecase.ouputPort.AddTaskInput;

import java.util.ArrayList;
import java.util.List;

public class AddTaskUseCase {
    private final ProjectList taskList;

    public AddTaskUseCase(ProjectList taskList){
        this.taskList = taskList;
    }

    public List<String> execute(AddTaskInput input) {
        List<String> results = new ArrayList<>();
        if (!isProjectExist(ProjectName.of(input.projectName))) {
            results.add("Could not find a project with the name \"" + input.projectName + "\".");
            results.add("\r\n");
            return results;
        }
        taskList.addTask(ProjectName.of(input.projectName), TaskId.of(taskList.nextId()), input.description, false);
        return results;
    }

    private boolean isProjectExist(ProjectName projectName){
        return taskList.containsProject(projectName);
    }
}
