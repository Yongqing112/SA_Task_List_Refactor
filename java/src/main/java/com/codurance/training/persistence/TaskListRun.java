package com.codurance.training.persistence;

import com.codurance.training.interfaceAdapter.controller.CommandController;
import com.codurance.training.interfaceAdapter.presenter.CommandPresenter;
import com.codurance.training.persistence.io.Input;
import com.codurance.training.persistence.io.Output;
import com.codurance.training.usecase.UseCaseInteractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public final class TaskListRun implements Runnable {
    private static final String QUIT = "quit";
    private final Input reader;
    private final Output writer;
    private final UseCaseInteractor useCaseInteractor;
    private final CommandController commandController;
    private final CommandPresenter commandPresenter;

    public TaskListRun(Input reader, Output writer) {
        this.reader = reader;
        this.writer = writer;
        useCaseInteractor = new UseCaseInteractor();
        this.commandController = new CommandController(useCaseInteractor);
        this.commandPresenter = new CommandPresenter(useCaseInteractor);
    }

    public static void main(String[] args) throws Exception {
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
        commandController.executeController(commandLine);
        writer.printOutputData(commandPresenter.getResults());
    }
}