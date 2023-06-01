package com.profilePract.example.postgresql.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "t_floor")
@Table(name = "t_floor")
public class FloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "Floor number is required")
    private Integer floorNumber;

    @Column
    @NotBlank(message = "Name is required")
    private String name;

    @Column
    @NotBlank(message = "Description is required")
    private String description;

    @Column
    private String image;

    @OneToMany(mappedBy = "floor", targetEntity = FloorEnemyEntity.class)
    private List<FloorEnemyEntity> floorEnemyRelation = new ArrayList<>();

    @OneToMany(mappedBy = "floor", targetEntity = FloorItemEntity.class)
    private List<FloorItemEntity> floorItemRelation = new ArrayList<>();
}