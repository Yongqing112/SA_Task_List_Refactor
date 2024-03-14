package com.codurance.training.tasks.entity;

public record ProjectName(String name) {

    @Override
    public String toString(){
        return name;
    }
}
