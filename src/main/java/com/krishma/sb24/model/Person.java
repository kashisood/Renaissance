package com.krishma.sb24.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Data
public class Person {

    private final UUID id;
    @NotBlank
    private final String name;


    public Person(
                @JsonProperty("id") UUID id,
                @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
