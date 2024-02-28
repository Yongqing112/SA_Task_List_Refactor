package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Consumer;


public final class TaskListRun implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private Map<String, Consumer<String>> commandMap;
    private final BufferedReader in;
    private final PrintWriter out;
    private final TaskList taskList;

    private long lastId = 0;

    public TaskListRun(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
        taskList = new TaskList(in, out);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListRun(in, out).run();
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            initializeCommandMap();
            execute(command);
        }
    }

    private void initializeCommandMap() {
        commandMap = new HashMap<String, Consumer<String>>();
        commandMap.put("show", this::show);
        commandMap.put("add", this::add);
        commandMap.put("delete", this::delete);
        commandMap.put("check", this::check);
        commandMap.put("uncheck", this::uncheck);
        commandMap.put("help", this::help);
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];

        commandMap.getOrDefault(command, this::error).accept(commandRest.length > 1 ? commandRest[1] : null);
    }
}
