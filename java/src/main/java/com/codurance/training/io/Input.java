package com.codurance.training.io;

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
