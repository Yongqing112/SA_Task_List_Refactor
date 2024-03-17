package com.codurance.training.tasks.entity;

import java.util.*;

public class Tasks {
    private final List<Project> projects = new ArrayList<>();

    public List<Project> getProject() {
        return projects;
    }

    public void add(ProjectName projectName, List<Task> tasks){
        this.projects.add(new Project(projectName, tasks));
    }

    public List<Task> get(ProjectName projectName){
        for(Project project: projects){
            if(project.equals(projectName)){
                return project.getTasks();
            }
        }
        return null;
    }

    public boolean containsKey(ProjectName projectName){
        for(Project project: projects){
            if(project.equals(projectName)){
                return true;
            }
        }
        return false;
    }

}
