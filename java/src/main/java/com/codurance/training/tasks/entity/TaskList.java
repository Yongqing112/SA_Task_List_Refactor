package com.codurance.training.tasks.entity;

import tw.teddysoft.ezddd.core.entity.AggregateRoot;
import tw.teddysoft.ezddd.core.entity.DomainEvent;

import java.util.List;

public final class TaskList extends AggregateRoot<TaskListId, DomainEvent>{

    private final TaskListId id;
    private final ProjectList projectList;
    private static long lastId = 0;

    public TaskList(TaskListId id) {
        this.id = id;
        this.projectList = new ProjectList();
    }

    public List<Project> getProjectList(){
        return projectList.getProjectList();

    }

    public long nextId() {
        return ++lastId;
    }

    public boolean containsProject(ProjectName projectName) {
        return projectList.containsProject(projectName);
    }

    public void addProject(ProjectName projectName, List<Task> tasks) {
        projectList.addProject(projectName, tasks);
    }

    public void addTask(ProjectName projectName, TaskId taskId, String description, boolean done) {
        projectList.addTask(projectName, taskId, description, done);
    }

    public List<String> setDone(String idString, boolean done) {
        return projectList.setDone(idString, done);
    }

    @Override
    public TaskListId getId() {
        return id;
    }
}
