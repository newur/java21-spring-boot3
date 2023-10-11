package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public record HeavyPackage(String address, int weight) implements AbstractPackage {

    @JsonGetter("type")
    public String type() {
        return "heavyPackage";
    }

    @Override
    public String description() {
        return "I am a heavy one.";
    }
}
