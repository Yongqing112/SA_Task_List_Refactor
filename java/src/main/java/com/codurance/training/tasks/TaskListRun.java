package com.codurance.training.tasks;

import com.codurance.training.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public final class TaskListRun implements Runnable {
    private static final String QUIT = "quit";

    private Map<String, Command> commandMap;
    private final BufferedReader in;
    private final PrintWriter out;
    private final TaskList taskList;

    public TaskListRun(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
        taskList = new TaskList();
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
        commandMap.put("show", new ShowCommand(taskList));
        commandMap.put("add", new AddCommand(taskList));
        commandMap.put("check", new CheckCommand(taskList));
        commandMap.put("uncheck", new UnCheckCommand(taskList));
        commandMap.put("help", new HelpCommand());
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        Command command = commandMap.getOrDefault(commandRest[0], new ErrorCommand());
        if(commandRest.length > 1){
            List<String> results = command.execute(commandRest[1]);
            for(String result: results){
                out.print(result);
            }
        }
        else{
            List<String> results = command.execute(commandLine);
            for(String result: results){
                out.print(result);
            }
        }
    }
}