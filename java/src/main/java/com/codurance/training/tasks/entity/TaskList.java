package com.codurance.training.tasks.entity;

import java.util.Collections;
import java.util.List;

public final class TaskList {

    private final ProjectList projectList = new ProjectList();
    private static long lastId = 0;


    public TaskList() {
    }

    public List<Project> getProjectList(){
        return Collections.unmodifiableList(projectList.getProjectList());
    }

    public long nextId() {
        return ++lastId;
    }

    public void addProject(ProjectName projectName, List<Task> tasks) {
        projectList.addProject(projectName, tasks);
    }

    public boolean containsKey(ProjectName projectName) {
        return projectList.containsKey(projectName);
    }

    public void addTask(ProjectName projectName, Task task) {
        projectList.addTask(projectName, task);
    }
}
