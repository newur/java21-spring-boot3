package com.example.demo.entity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoxMapper {

    SmallBoxRecord entityToRecord(SmallBox smallBox);

    SmallBox recordToEntity(SmallBoxRecord smallBoxRecord);

    BigBoxRecord entityToRecord(BigBox bigBox);

    BigBox recordToEntity(BigBoxRecord bigBoxRecord);

    default Box mapAbstractEntity(AbstractBox abstractBox) {
        return switch (abstractBox) {
            case BigBox biggy -> entityToRecord(biggy);
            case SmallBox smally -> entityToRecord(smally);
            default -> throw new RuntimeException();
        };
    }
}
