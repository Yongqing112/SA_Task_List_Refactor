package com.codurance.training.tasks.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public final class TaskList {

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private static long lastId = 0;


    public TaskList() {
    }

    public Map<String, List<Task>> getTaskList(){
        return tasks;
    }

    public long nextId() {
        return ++lastId;
    }
}
