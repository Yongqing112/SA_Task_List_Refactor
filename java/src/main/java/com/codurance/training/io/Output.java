package com.codurance.training.io;

import java.io.PrintWriter;
import java.util.List;

public class Output {
    private final PrintWriter out;

    public Output(PrintWriter out) {
        this.out = out;
    }

    public void cmd(){
        out.print("> ");
        out.flush();
    }

    public void output(List<String> results){
        for(String result: results){
            out.print(result);
        }
    }
}
