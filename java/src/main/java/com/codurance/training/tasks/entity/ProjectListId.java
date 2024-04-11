package com.codurance.training.tasks.entity;

public record ProjectListId(String taskListId) {
    public static ProjectListId of(String taskListId) {
        return new ProjectListId(taskListId);
    }
}
