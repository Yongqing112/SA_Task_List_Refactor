package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ShowCommand implements Command{
    private final PrintWriter out;
    private final Map<String, List<Task>> projects;

    public ShowCommand(Map<String, List<Task>> projects, PrintWriter out){
        this.projects = projects;
        this.out = out;
    }

    private void displayTask(List<Task> taskList){
        for (Task task : taskList) {
            out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
        }
    }
    @Override
    public void execute(String arg) {
        for (Map.Entry<String, List<Task>> project : projects.entrySet()) {
            out.println(project.getKey());
            displayTask(project.getValue());
            out.println();
        }
    }
}
