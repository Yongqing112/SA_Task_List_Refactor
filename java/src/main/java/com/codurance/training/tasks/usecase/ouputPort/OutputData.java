package com.codurance.training.tasks.usecase.ouputPort;

import java.util.List;

public class OutputData implements OutputBoundary{
    private final List<String> results;

    public OutputData(List<String> results) {
        this.results = results;
    }

    @Override
    public List<String> getResults() {
        return results;
    }
}
