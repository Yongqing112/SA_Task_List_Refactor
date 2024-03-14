package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.entity.Tasks;
import com.codurance.training.tasks.usecase.inputPort.InputBoundary;

import java.util.ArrayList;
import java.util.List;

public class AddCommand implements Command {
    private final TaskList taskList;

    public AddCommand(TaskList taskList){
        this.taskList = taskList;
    }

    @Override
    public List<String> execute(InputBoundary inputSubcommand) {
        String[] subcommandRest = inputSubcommand.getInputCommand();
        String subcommand = subcommandRest[0];
        List<String> results = new ArrayList<>();
        if (subcommand.equals("project")) {
            addProject(new ProjectName(subcommandRest[1]), this.taskList.getTasks());
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(new ProjectName(projectTask[0]), projectTask[1], taskList.getTasks(), results);
        }
        return results;
    }

    private void addProject(ProjectName projectName, Tasks tasks) {
        tasks.put(projectName, new ArrayList<>());
    }

    private boolean isProjectExist(ProjectName projectName, Tasks tasks){
        return tasks.containsKey(projectName);
    }

    private void addTask(ProjectName projectName, String description, Tasks tasks, List<String> results) {
        if (!isProjectExist(projectName, tasks)) {
            results.add("Could not find a project with the name \"" + projectName + "\".");
            results.add("\r\n");
            return;
        }
        List<Task> projectTasks = tasks.get(projectName);
        projectTasks.add(new Task(taskList.nextId(), description, false));
    }
}
