package com.codurance.training.tasks;

import java.io.PrintWriter;

public class Output {

    private static final Output instance  = new Output();
    private final PrintWriter out;

    private Output(){
        out = new PrintWriter(System.out);
    }

    public static Output getInstance(){
        return instance;
    }

    public PrintWriter output(){
        return out;
    }
}
