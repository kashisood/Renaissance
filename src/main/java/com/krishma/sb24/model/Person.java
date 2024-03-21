package com.krishma.sb24.model;

import lombok.*;

import java.util.UUID;

@Data
public class Person {

    private final UUID id;
    private final String name;


    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
