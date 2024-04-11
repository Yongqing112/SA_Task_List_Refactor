package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.ProjectList;
import com.codurance.training.tasks.usecase.inputPort.AddProjectInput;

import java.util.ArrayList;
import java.util.List;

public class AddProjectUseCase {
    private final ProjectList taskList;

    public AddProjectUseCase(ProjectList taskList) {
        this.taskList = taskList;
    }

    public List<String> execute(AddProjectInput input) {
        taskList.addProject(ProjectName.of(input.projectName), new ArrayList<>());
        return new ArrayList<>();
    }
}
