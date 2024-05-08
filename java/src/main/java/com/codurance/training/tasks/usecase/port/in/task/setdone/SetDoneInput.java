package com.codurance.training.tasks.usecase.port.in.task.setdone;

import tw.teddysoft.ezddd.core.usecase.Input;

public class SetDoneInput implements Input {
    public String id;
    public boolean done;
    public String projectListId;
}
