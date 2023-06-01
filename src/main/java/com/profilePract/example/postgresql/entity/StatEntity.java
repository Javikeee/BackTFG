package com.profilePract.example.postgresql.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "t_stat")
@Table(name = "t_stat")
public class StatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank(message = "Name is required")
    private String name;

    @OneToMany(mappedBy = "stat", targetEntity = StatCharacterEntity.class)
    private List<StatCharacterEntity> statCharacterRelation = new ArrayList<>();

    @OneToMany(mappedBy = "stat", targetEntity = StatItemEntity.class)
    private List<StatItemEntity> statItemEntityRelation = new ArrayList<>();

    @OneToMany(mappedBy = "stat", targetEntity = StatEnemyEntity.class)
    private List<StatEnemyEntity> statEnemyRelation = new ArrayList<>();
}
