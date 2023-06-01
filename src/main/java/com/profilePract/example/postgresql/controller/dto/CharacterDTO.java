package com.profilePract.example.postgresql.controller.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO implements Serializable {

    @Schema(description = "Identifier, PK for Character")
    private Integer id;
    @Schema(example = "Isaac", description = "Character name")
    private String name;
    @Schema(example = "His life was simple but one day his mother did a devil contract that make the rest of his life an hell", description = "Character history")
    private String history;
    private String image;
}