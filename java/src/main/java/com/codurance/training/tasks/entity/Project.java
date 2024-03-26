package com.codurance.training.tasks.entity;

import java.util.ArrayList;
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

    private Task findTask(int id){
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public List<String> setDone(int id, boolean done) {
        List<String> results = new ArrayList<>();
        Task task = findTask(id);
        if(task != null){
            task.setDone(done);
            return results;
        }
        results.add("Could not find a task with an ID of " + id + ".");
        results.add("\r\n");
        return results;
    }
}
