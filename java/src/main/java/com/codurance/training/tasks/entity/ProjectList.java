package com.codurance.training.tasks.entity;

import tw.teddysoft.ezddd.core.entity.AggregateRoot;
import tw.teddysoft.ezddd.core.entity.DomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class ProjectList extends AggregateRoot<ProjectListId, DomainEvent>{

    private final ProjectListId id;
    private final List<Project> projects;
    private static long lastId = 0;

    public ProjectList(ProjectListId id) {
        this.id = id;
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjectList() {
        return projects.stream()
                .map(p -> (Project) new ReadOnlyProject(p.getName(), p.getTasks()))
                .toList();
    }

    public void addProject(ProjectName projectName, List<Task> tasks){
        this.projects.add(new Project(projectName, tasks));
    }

    public boolean containsProject(ProjectName projectName){
        for(Project project: projects){
            if(project.getProjectName().equals(projectName)){
                return true;
            }
        }
        return false;
    }

    private Project findProject(ProjectName projectName){
        Optional<Project> p =
                projects.stream()
                        .filter(project -> project.getProjectName().equals(projectName))
                        .findFirst();
        if(p.isEmpty()){
            return null;
        }
        return p.get();
    }

    public void addTask(ProjectName projectName, TaskId taskId, String description, boolean done) {
        Project project = findProject(projectName);
        if(project != null){
            project.addTask(taskId, description, done);
        }
    }

    public boolean containTask(TaskId taskId) {
        return projects.stream().anyMatch(p-> p.containTask(taskId.toString()));
    }

    public List<String> setDone(String idString, boolean done) {
        List<String> results = new ArrayList<>();
        for (Project project : projects) {
            results = project.setDone(idString, done);
            if(results.isEmpty()){
                return results;
            }
        }
        return results;
    }

    public long nextId() {
        return ++lastId;
    }

    @Override
    public ProjectListId getId() {
        return id;
    }
}
