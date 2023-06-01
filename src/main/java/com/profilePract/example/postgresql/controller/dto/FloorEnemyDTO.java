package com.profilePract.example.postgresql.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FloorEnemyDTO implements Serializable {

    @Schema(description = "Identifier, PK for FloorEnemy")
    private Integer id;

    @Schema(example = "1", description = "Identifier, PK for Floor")
    private FloorDTOMinified floor;

    @Schema(example = "1", description = "Identifier, PK for Enemy")
    private EnemyDTO enemy;

}
