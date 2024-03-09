package com.codurance.training.command;

import com.codurance.training.tasks.Task;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class UnCheckCommand implements Command {
    private final PrintWriter out;

    private final Map<String, List<Task>> projects;

    public UnCheckCommand(Map<String, List<Task>> projects, PrintWriter out){
        this.projects = projects;
        this.out = out;
    }

    @Override
    public void execute(String idString) {
        setDone(idString, false, projects);
    }

    private Task findTask(int id, Map.Entry<String, List<Task>> project){
        for (Task task : project.getValue()) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private void setDone(String idString, boolean done, Map<String, List<Task>> projects) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : projects.entrySet()) {
            Task task = findTask(id, project);
            if(task != null){
                task.setDone(done);
                return;
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
