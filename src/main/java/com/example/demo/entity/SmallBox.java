package com.example.demo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("smallBox")
public class SmallBox extends AbstractBox {

    private Boolean padded;

    public SmallBox(Boolean padded) {
        this.padded = padded;
    }
}
