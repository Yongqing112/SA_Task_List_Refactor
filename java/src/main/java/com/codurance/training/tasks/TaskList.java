package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


public final class TaskList {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private Map<String, Consumer<String>> commandMap;
    private final BufferedReader in;
    private final PrintWriter out;

    private long lastId = 0;

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    private void displayTask(List<Task> taskList){
        for (Task task : taskList) {
            out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
        }
    }

    public void show() {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            displayTask(project.getValue());
            out.println();
        }
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {
        tasks.put(name, new ArrayList<Task>());
    }

    private boolean isProjectExist(String project){
        return tasks.containsKey(project);
    }

    private void addTask(String project, String description) {
        if (!isProjectExist(project)) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        List<Task> projectTasks = tasks.get(project);
        projectTasks.add(new Task(nextId(), description, false));
    }

    private int taskIndex(int id, List<Task> taskList){
        for (Task task : taskList) {
            if (task.getId() == id) {
                return taskList.indexOf(task);
            }
        }
        return -1;
    }

    private void delete(String idString){
        int id = Integer.parseInt(idString);
        for (List<Task> taskList: tasks.values()) {
            int index = taskIndex(id, taskList);
            if(index != -1){
                taskList.remove(index);
                return;
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }

    private void check(String idString) {
        setDone(idString, true);
    }

    private void uncheck(String idString) {
        setDone(idString, false);
    }

    private Task findTask(int id, Map.Entry<String, List<Task>> project){
        for (Task task : project.getValue()) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            Task task = findTask(id, project);
            if(task != null){
                task.setDone(done);
                return;
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }

    private void help(String arg) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

    private long nextId() {
        return ++lastId;
    }
}
