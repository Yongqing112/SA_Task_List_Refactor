package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.ProjectList;
import com.codurance.training.tasks.entity.ProjectListId;
import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.usecase.ProjectListRepository;
import com.codurance.training.tasks.usecase.port.in.project.add.AddProjectInput;
import com.codurance.training.tasks.usecase.port.in.project.add.AddProjectUseCase;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import java.util.ArrayList;
import java.util.Optional;

public class AddProjectService implements AddProjectUseCase {
    private final ProjectListRepository repository;

    public AddProjectService(ProjectListRepository repository) {
        this.repository = repository;
    }

    public CqrsOutput execute(AddProjectInput projectInput) {
        Optional<ProjectList> projectList = repository.findById(ProjectListId.of(projectInput.projectListId));
        projectList.get().addProject(ProjectName.of(projectInput.projectName), new ArrayList<Task>());
        repository.save(projectList.get());

        return CqrsOutput.create().succeed().setId(projectInput.projectName);
    }
}
