package com.profilePract.example.postgresql.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FloorDTOMinified implements Serializable {

    @Schema(example = "1", description = "Identifier, PK for Floor")
    private Integer id;
    @Schema(example = "1", description = "Floor number")
    private Integer floorNumber;
    @Schema(example = "Basement", description = "Floor name")
    private String name;

}