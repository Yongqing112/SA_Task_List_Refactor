package com.codurance.training.tasks.entity;

import tw.teddysoft.ezddd.core.entity.ValueObject;

public record ProjectName(String name) implements ValueObject {

    public static ProjectName of(String name) {
        return new ProjectName(name);
    }
}
