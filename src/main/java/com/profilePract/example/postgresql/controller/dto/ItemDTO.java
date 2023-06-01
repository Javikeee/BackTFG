package com.profilePract.example.postgresql.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements Serializable{

    @Schema(description = "Identifier, PK for Item")
    private Integer id;
    @Schema(example = "D5", description = "Item name")
    private String name;
    @Schema(example = "Dice that roll all the pedestal items in the room", description = "Item description")
    private String description;
    private String image;
}
