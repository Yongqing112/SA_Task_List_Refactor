package com.codurance.training.tasks.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public final class TaskList {

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    public TaskList() {
    }

    public Map<String, List<Task>> getTaskList(){
        return tasks;
    }
}
