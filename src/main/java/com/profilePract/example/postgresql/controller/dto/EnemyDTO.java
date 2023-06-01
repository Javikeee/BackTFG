package com.profilePract.example.postgresql.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnemyDTO implements Serializable {

    @Schema(description = "Identifier, PK for Enemy")
    private Integer id;
    @Schema(example = "Bobba", description = "Enemy name")
    private String name;
    @Schema(example = "Basic enemy that looks like Isaac", description = "Enemy description")
    private String description;
    private String image;
}