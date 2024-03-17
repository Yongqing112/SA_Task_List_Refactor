package com.codurance.training.tasks.entity;

import java.util.List;

public record Project(ProjectName projectName, List<Task> tasks) {
    public List<Task> getTasks() {
        return tasks;
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public boolean equals(ProjectName projectName) {
        return this.projectName.toString().equals(projectName.toString());
    }
}
