package com.codurance.training.tasks.usecase.service;

import com.codurance.training.tasks.entity.ProjectList;
import com.codurance.training.tasks.entity.ProjectListId;
import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.TaskId;
import com.codurance.training.tasks.usecase.ProjectListRepository;
import com.codurance.training.tasks.usecase.ouputPort.AddTaskInput;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;
import tw.teddysoft.ezddd.cqrs.usecase.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AddTaskUseCase
        extends Command<AddTaskInput, CqrsOutput> {
}
