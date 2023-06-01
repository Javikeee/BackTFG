package com.profilePract.example.postgresql.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FloorDTO implements Serializable{

    @Schema(description = "Identifier, PK for Floor")
    private Integer id;
    @Schema(example = "1", description = "Floor number")
    private Integer floorNumber;
    @Schema(example = "Basement", description = "Floor name")
    private String name;
    @Schema(example = "First floor of the game, when it starts", description = "Description name")
    private String description;
    private String image;
}