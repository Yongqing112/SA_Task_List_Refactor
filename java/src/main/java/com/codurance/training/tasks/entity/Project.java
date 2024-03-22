package com.codurance.training.tasks.entity;

import java.util.Collections;
import java.util.List;

public class Project {
    private final ProjectName projectName;
    private final List<Task> tasks;
    public Project(ProjectName projectName, List<Task> tasks){
        this.projectName = projectName;
        this.tasks = tasks;

    }
    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
