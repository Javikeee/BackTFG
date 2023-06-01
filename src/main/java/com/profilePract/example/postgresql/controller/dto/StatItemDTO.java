package com.profilePract.example.postgresql.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatItemDTO implements Serializable {

    @Schema(description = "Identifier, PK for StatItem")
    private Integer id;

    @Schema(example = "1", description = "Identifier, PK for Stat")
    private StatDTO stat;

    @Schema(example = "1", description = "Identifier, PK for Item")
    private ItemDTO item;

    @Schema(example = "2", description = "StatEnemy value")
    private float value;

}
