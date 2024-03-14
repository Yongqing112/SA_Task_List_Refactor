package com.codurance.training.tasks.persistence;

import com.codurance.training.tasks.interfaceAdapter.interfaceAdapter.controller.CommandController;
import com.codurance.training.tasks.interfaceAdapter.interfaceAdapter.presenter.CommandPresenter;
import com.codurance.training.tasks.persistence.io.Input;
import com.codurance.training.tasks.persistence.io.Output;
import com.codurance.training.tasks.usecase.UseCaseInteractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public final class TaskListRunner implements Runnable {
    private static final String QUIT = "quit";
    private final Input reader;
    private final Output writer;
    private final CommandController commandController;

    public TaskListRunner(Input reader, Output writer) {
        this.reader = reader;
        this.writer = writer;
        UseCaseInteractor useCaseInteractor = new UseCaseInteractor();
        this.commandController = new CommandController(useCaseInteractor);
    }

    public static void main(String[] args) throws Exception {
        Input reader = new Input( new BufferedReader(new InputStreamReader(System.in)));
        Output writer = new Output(new PrintWriter(System.out));
        new TaskListRunner(reader, writer).run();
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
        CommandPresenter commandPresenter = new CommandPresenter(commandController.executeController(commandLine));
        writer.printOutputData(commandPresenter.getResults());
    }
}