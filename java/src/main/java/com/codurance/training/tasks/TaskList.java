package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public final class TaskList {
    private static final String QUIT = "quit";

    private static final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    public TaskList() {
    }

    public static Map<String, List<Task>> getTaskList(){
        return tasks;
    }
}
