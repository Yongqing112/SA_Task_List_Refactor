package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.ProjectList;
import com.codurance.training.tasks.usecase.inputPort.SetDoneInput;

import java.util.List;

public class SetDoneUseCase {
    private final ProjectList taskList;

    public SetDoneUseCase(ProjectList taskList){
        this.taskList = taskList;
    }

    public List<String> execute(SetDoneInput input) {
        return taskList.setDone(input.id, input.done);
    }
}
