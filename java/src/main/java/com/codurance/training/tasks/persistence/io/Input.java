package com.codurance.training.tasks.persistence.io;

import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    private final BufferedReader in;

    public Input(BufferedReader in){
        this.in = in;
    }

    public String readLine() throws IOException {
        return in.readLine();
    }
}
