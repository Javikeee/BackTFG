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
public class FloorItemDTO implements Serializable{

    @Schema(description = "Identifier, PK for FloorItem")
    private Integer id;

    @Schema(example = "1", description = "Identifier, PK for Floor")
    private FloorDTOMinified floor;

    @Schema(example = "1", description = "Identifier, PK for Item")
    private ItemDTO item;

}
