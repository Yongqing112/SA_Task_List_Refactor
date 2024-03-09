package com.codurance.training.usecase.command;

import com.codurance.training.entity.Task;
import com.codurance.training.entity.TaskList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddCommand implements Command {
    private final TaskList taskList;
    private static long lastId = 0;
    private final List<String> results;

    public AddCommand(TaskList taskList){
        this.taskList = taskList;
        this.results = new ArrayList<String>();
    }

    @Override
    public List<String> execute(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1], this.taskList.getTaskList());
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1], taskList.getTaskList());
        }
        return results;
    }

    private void addProject(String name, Map<String, List<Task>> projects) {
        projects.put(name, new ArrayList<Task>());
    }

    private boolean isProjectExist(String project, Map<String, List<Task>> projects){
        return projects.containsKey(project);
    }

    private void addTask(String project, String description, Map<String, List<Task>> projects) {
        if (!isProjectExist(project, projects)) {
            results.add("Could not find a project with the name \"" + project + "\".");
            results.add("\r\n");
            return;
        }
        List<Task> projectTasks = projects.get(project);
        projectTasks.add(new Task(nextId(), description, false));
    }

    private long nextId() {
        return ++lastId;
    }
}
