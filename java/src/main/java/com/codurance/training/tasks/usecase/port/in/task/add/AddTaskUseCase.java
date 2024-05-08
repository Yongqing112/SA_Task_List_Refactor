package com.codurance.training.tasks.usecase.port.in.task.add;

import com.codurance.training.tasks.usecase.port.in.task.add.AddTaskInput;
import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;
import tw.teddysoft.ezddd.cqrs.usecase.command.Command;

public interface AddTaskUseCase
        extends Command<AddTaskInput, CqrsOutput> {
}
