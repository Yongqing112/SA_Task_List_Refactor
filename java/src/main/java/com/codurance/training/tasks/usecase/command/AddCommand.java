package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddCommand implements Command {
    private final TaskList taskList;

    public AddCommand(TaskList taskList){
        this.taskList = taskList;
    }

    @Override
    public List<String> execute(String[] subcommandRest) {
        String subcommand = subcommandRest[0];
        List<String> results = new ArrayList<>();
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1], this.taskList.getTaskList());
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1], taskList.getTaskList(), results);
        }
        return results;
    }

    private void addProject(String name, Map<String, List<Task>> projects) {
        projects.put(name, new ArrayList<>());
    }

    private boolean isProjectExist(String project, Map<String, List<Task>> projects){
        return projects.containsKey(project);
    }

    private void addTask(String project, String description, Map<String, List<Task>> projects, List<String> results) {
        if (!isProjectExist(project, projects)) {
            results.add("Could not find a project with the name \"" + project + "\".");
            results.add("\r\n");
            return;
        }
        List<Task> projectTasks = projects.get(project);
        projectTasks.add(new Task(taskList.nextId(), description, false));
    }
}
