package com.example.demo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("bigBox")
public class BigBox extends AbstractBox {

    private Integer weight;

    public BigBox(Integer weight) {
        super();
        this.weight = weight;
    }
}
