package com.codurance.training.io;

import com.codurance.training.interfaceAdapter.controller.CommandController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public final class TaskListRun implements Runnable {
    private static final String QUIT = "quit";
    private final Input reader;
    private final Output writer;
    private final CommandController commandController;

    public TaskListRun(Input reader, Output writer) {
        this.reader = reader;
        this.writer = writer;
        this.commandController = new CommandController();
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Input reader = new Input( new BufferedReader(new InputStreamReader(System.in)));
        Output writer = new Output(new PrintWriter(System.out));
        new TaskListRun(reader, writer).run();
    }

    public void run() {
        while (true) {
            writer.cmd();
            String command;
            try {
                command = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        commandController.execute(commandLine);
        writer.output(commandController.getResults());
    }
}