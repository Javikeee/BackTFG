package com.profilePract.example.postgresql.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatCharacterDTO implements Serializable {

    @Schema(description = "Identifier, PK for StatCharacter")
    private Integer id;

    @Schema(example = "1", description = "Identifier, PK for Stat")
    private StatDTO stat;

    @Schema(example = "1", description = "Identifier, PK for Character")
    private CharacterDTO character;

    @Schema(example = "2", description = "StatCharacter value")
    private float value;

}