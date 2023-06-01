package com.profilePract.example.postgresql.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatDTO implements Serializable {

    @Schema(description = "Identifier, PK for Stat")
    private Integer id;
    @Schema(example = "health", description = "Stat name")
    private String name;

}
