package com.profilePract.example.postgresql.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "t_enemy")
@Table(name = "t_enemy")
public class EnemyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank(message = "Name is required")
    private String name;

    @Column
    @NotBlank(message = "Description is required")
    private String description;

    @Column
    private String image;

    @OneToMany(mappedBy = "enemy", targetEntity = StatEnemyEntity.class)
    private List<StatEnemyEntity> statEnemyRelation = new ArrayList<>();

    @OneToMany(mappedBy = "enemy", targetEntity = FloorEnemyEntity.class)
    private List<FloorEnemyEntity> floorEnemyRelation = new ArrayList<>();

}