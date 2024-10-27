package com.codurance.training.tasks.entity;

import java.util.*;

public class Tasks {
    private final Map<ProjectName, List<Task>> tasks;

    public Tasks() {
        this.tasks = new LinkedHashMap<>();
    }

    public Set<Map.Entry<ProjectName, List<Task>>> entrySet() {
        return tasks.entrySet();
    }

    public void put(ProjectName projectName, ArrayList<Task> tasks) {
        this.tasks.put(projectName, tasks);
    }

    public List<Task> get(ProjectName projectName) {
        return tasks.get(projectName);
    }
}
