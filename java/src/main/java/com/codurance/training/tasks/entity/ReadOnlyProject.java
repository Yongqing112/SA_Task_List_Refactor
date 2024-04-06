package com.codurance.training.tasks.entity;

import java.util.List;

public class ReadOnlyProject extends Project{

    public ReadOnlyProject(ProjectName name, List<Task> tasks) {
        super(name, tasks);
    }
}