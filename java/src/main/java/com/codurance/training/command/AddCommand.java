package com.codurance.training.command;

import com.codurance.training.tasks.Task;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddCommand implements Command {
    private final PrintWriter out;
    private final Map<String, List<Task>> projects;
    private static long lastId = 0;

    public AddCommand(Map<String, List<Task>> projects, PrintWriter out){
        this.projects = projects;
        this.out = out;
    }

    @Override
    public void execute(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1], this.projects);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1], projects);
        }
    }

    private void addProject(String name, Map<String, List<Task>> projects) {
        projects.put(name, new ArrayList<Task>());
    }

    private boolean isProjectExist(String project, Map<String, List<Task>> projects){
        return projects.containsKey(project);
    }

    private void addTask(String project, String description, Map<String, List<Task>> projects) {
        if (!isProjectExist(project, projects)) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        List<Task> projectTasks = projects.get(project);
        projectTasks.add(new Task(nextId(), description, false));
    }

    private long nextId() {
        return ++lastId;
    }
}
