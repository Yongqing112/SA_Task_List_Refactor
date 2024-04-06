package com.codurance.training.tasks.entity;

import tw.teddysoft.ezddd.core.entity.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project implements Entity<ProjectName> {
    private final ProjectName projectName;
    private final List<Task> tasks;
    public Project(ProjectName projectName, List<Task> tasks){
        this.projectName = projectName;
        this.tasks = tasks;
    }
    public List<Task> getTasks() {
        return tasks.stream()
                .map(t -> (Task) new ReadOnlyTask(t.getId(), t.getDescription(), t.isDone()))
                .toList();
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public void addTask(TaskId taskId, String description, boolean done) {
        tasks.add(new Task(taskId, description, done));
    }

    private Task findTask(String idString){
        TaskId id = TaskId.of(idString);
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public List<String> setDone(String idString, boolean done) {
        List<String> results = new ArrayList<>();
        Task task = findTask(idString);
        if(task != null){
            task.setDone(done);
            return results;
        }
        results.add("Could not find a task with an ID of " + idString + ".");
        results.add("\r\n");
        return results;
    }

    public ProjectName getName() {
        return projectName;
    }

    @Override
    public ProjectName getId() {
        return projectName;
    }
}
