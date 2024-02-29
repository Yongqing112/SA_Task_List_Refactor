package com.codurance.training.tasks;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class DeleteCommand implements Command {

    private final PrintWriter out;
    private final Map<String, List<Task>> projects;

    public DeleteCommand(Map<String, List<Task>> projects, PrintWriter out){
        this.projects = projects;
        this.out = out;
    }


    private int taskIndex(int id, List<Task> taskList){
        for (Task task : taskList) {
            if (task.getId() == id) {
                return taskList.indexOf(task);
            }
        }
        return -1;
    }

    @Override
    public void execute(String idString) {
        int id = Integer.parseInt(idString);
        for (List<Task> taskList: projects.values()) {
            int index = taskIndex(id, taskList);
            if(index != -1){
                taskList.remove(index);
                return;
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
