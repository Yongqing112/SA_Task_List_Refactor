package com.codurance.training.tasks.entity;

public final class TaskList {

    private final Tasks tasks = new Tasks();
    private static long lastId = 0;


    public TaskList() {
    }

    public Tasks getTasks(){
        return tasks;
    }

    public long nextId() {
        return ++lastId;
    }
}
