package com.codurance.training.tasks.entity;

public record TaskListId(String taskListId) {
    public static TaskListId of(String taskListId) {
        return new TaskListId(taskListId);
    }
}
