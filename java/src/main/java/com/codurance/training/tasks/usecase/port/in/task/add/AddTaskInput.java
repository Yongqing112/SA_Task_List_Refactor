package com.codurance.training.tasks.usecase.port.in.task.add;

import tw.teddysoft.ezddd.core.usecase.Input;

public class AddTaskInput implements Input {
    public String projectName;
    public String description;
    public String projectListId;
}
