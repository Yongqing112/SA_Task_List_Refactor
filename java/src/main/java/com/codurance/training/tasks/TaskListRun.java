package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Consumer;


public final class TaskListRun implements Runnable {
    private static final String QUIT = "quit";
    private Map<String, Command> commandMap;
    private final BufferedReader in;
    private final PrintWriter out;
    private static final TaskList taskList = new TaskList();

    private String[] commandRest;

    public TaskListRun(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
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
        commandMap = new HashMap<String, Command>();
        commandMap.put("show", new ShowCommand());
        commandMap.put("add", new AddCommand());
        commandMap.put("delete", new DeleteCommand());
        commandMap.put("check", new CheckCommand());
        commandMap.put("uncheck", new UnCheckCommand());
        commandMap.put("help", new HelpCommand());
    }

    private void execute(String commandLine) {
        commandRest = commandLine.split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], new ErrorCommand());
        if(commandRest.length > 1){
            command.execute(commandRest[1], taskList.getTaskList());
        }
        else{
            command.execute(null, taskList.getTaskList());
        }
    }
}
