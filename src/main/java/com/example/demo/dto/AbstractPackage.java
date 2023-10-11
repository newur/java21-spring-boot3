package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LightPackage.class, name = "lightPackage"),
        @JsonSubTypes.Type(value = HeavyPackage.class, name = "heavyPackage")})
public sealed interface AbstractPackage permits LightPackage, HeavyPackage {

    String description();
}
