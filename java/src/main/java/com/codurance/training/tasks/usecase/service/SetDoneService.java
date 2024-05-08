package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.ProjectList;
import com.codurance.training.tasks.entity.ProjectListId;
import com.codurance.training.tasks.entity.TaskId;
import com.codurance.training.tasks.usecase.ProjectListRepository;
import com.codurance.training.tasks.usecase.port.in.task.setdone.SetDoneInput;
import com.codurance.training.tasks.usecase.port.in.task.setdone.SetDoneUseCase;
import tw.teddysoft.ezddd.core.usecase.ExitCode;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

import java.util.Optional;

import static java.lang.String.format;

public class SetDoneService implements SetDoneUseCase {
    private final ProjectListRepository repository;

    public SetDoneService(ProjectListRepository repository){
        this.repository = repository;
    }

    public CqrsOutput execute(SetDoneInput setDoneInput) {
        Optional<ProjectList> projectList = repository.findById(ProjectListId.of(setDoneInput.projectListId));
        if (!projectList.get().containTask(TaskId.of(setDoneInput.id))){
            String out = "Could not find a task with an ID of " + setDoneInput.id + ".\r\n";
            return CqrsOutput.create().setExitCode(ExitCode.FAILURE).setMessage(out);
        }
        projectList.get().setDone(setDoneInput.id, setDoneInput.done);
        return CqrsOutput.create().setExitCode(ExitCode.SUCCESS).setMessage("");
    }
}
