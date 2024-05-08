package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.*;
import com.codurance.training.tasks.usecase.ProjectListRepository;
import com.codurance.training.tasks.usecase.ouputPort.AddTaskInput;
import tw.teddysoft.ezddd.core.usecase.ExitCode;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddTaskService implements AddTaskUseCase {
    private final ProjectListRepository repository;

    public AddTaskService(ProjectListRepository repository){
        this.repository = repository;
    }

    public CqrsOutput execute(AddTaskInput addTaskInput) {
        Optional<ProjectList> projectList = repository.findById(ProjectListId.of(addTaskInput.projectListId));
        if (!projectList.get().containsProject(ProjectName.of(addTaskInput.projectName))) {
            String out = "Could not find a project with the name \"" + addTaskInput.projectName + "\".\r\n";
            return CqrsOutput.create().setExitCode(ExitCode.FAILURE).setMessage(out);
        }
        TaskId taskId = TaskId.of(projectList.get().nextId());
        projectList.get().addTask(ProjectName.of(addTaskInput.projectName), taskId, addTaskInput.description, false);
        return CqrsOutput.create().setExitCode(ExitCode.SUCCESS).setMessage("").setId(taskId.toString());
    }
}
