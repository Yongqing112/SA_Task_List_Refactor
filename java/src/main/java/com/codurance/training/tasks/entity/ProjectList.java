package com.codurance.training.tasks.entity;

import java.util.*;

public class ProjectList {
    private final List<Project> projects = new ArrayList<>();

    public List<Project> getProjectList() {
        return Collections.unmodifiableList(projects);
    }

    public void addProject(ProjectName projectName, List<Task> tasks){
        this.projects.add(new Project(projectName, tasks));
    }

    public boolean containsKey(ProjectName projectName){
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

    public void addTask(ProjectName projectName, Task task) {
        Project project = findProject(projectName);
        project.addTask(task);
    }

    public List<String> setDone(int id, boolean done) {
        List<String> results = new ArrayList<>();
        for (Project project : projects) {
            results = project.setDone(id, done);
            if(results.isEmpty()){
                return results;
            }
        }
        return results;
    }
}
