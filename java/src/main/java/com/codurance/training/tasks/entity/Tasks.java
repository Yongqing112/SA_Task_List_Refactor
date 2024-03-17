package com.codurance.training.tasks.entity;

import java.util.*;

public class Tasks {
    private final List<Project> tasks = new ArrayList<>();

    public List<Project> getProject() {
        return tasks;
    }

    public void add(ProjectName projectName, List<Task> tasks){
        this.tasks.add(new Project(projectName, tasks));
    }

    public List<Task> get(ProjectName projectName){
        for(Project project: tasks){
            if(project.equals(projectName)){
                return project.getTasks();
            }
        }
        return null;
    }

    public boolean containsKey(ProjectName projectName){
        for(Project project: tasks){
            if(project.equals(projectName)){
                return true;
            }
        }
        return false;
    }

}
