package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ShowCommand implements Command{
    private final PrintWriter out = Output.getInstance().output();

    public ShowCommand(){
    }

    private void displayTask(List<Task> taskList){
        for (Task task : taskList) {
            out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
        }
    }
    @Override
    public void execute(String arg, Map<String, List<Task>> projects) {
        for (Map.Entry<String, List<Task>> project : projects.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                System.out.println();
            }
            displayTask(project.getValue());
            out.println();
        }
    }
}
