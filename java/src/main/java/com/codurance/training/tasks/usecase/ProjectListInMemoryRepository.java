package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.ProjectList;
import com.codurance.training.tasks.entity.ProjectListId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectListInMemoryRepository implements ProjectListRepository<ProjectListId> {

    private final List<ProjectList> store = new ArrayList<>();


    @Override
    public Optional<ProjectList> findById(ProjectListId projectListId) {
        return store.stream().filter( projectList -> projectList.getId().equals(projectListId)).findFirst();
    }

    @Override
    public void save(ProjectList projectList) {
        store.remove(projectList);
        store.add(projectList);
    }
}
