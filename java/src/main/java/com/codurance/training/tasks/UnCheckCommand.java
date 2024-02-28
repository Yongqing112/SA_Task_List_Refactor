package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class UnCheckCommand implements Command{
    private final PrintWriter out = Output.getInstance().output();

    public UnCheckCommand(){
    }

    @Override
    public void execute(String idString, Map<String, List<Task>> projects) {
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
