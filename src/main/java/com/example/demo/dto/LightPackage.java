package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public record LightPackage(String address) implements AbstractPackage {

    @JsonGetter("type")
    public String type() {
        return "lightPackage";
    }

    @Override
    public String description() {
        return "I am a heavy one.";
    }
}
