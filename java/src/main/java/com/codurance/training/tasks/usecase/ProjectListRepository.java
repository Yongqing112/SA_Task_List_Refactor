package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.ProjectList;

import java.util.Optional;

public interface ProjectListRepository<ID> {

    Optional<ProjectList> findById(ID id);
    void save(ProjectList toDoList);
}
