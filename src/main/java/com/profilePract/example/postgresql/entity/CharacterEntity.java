package com.profilePract.example.postgresql.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name= "t_character")
@Table(name = "t_character")
public class CharacterEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank(message = "Name is required")
    private String name;

    @Column
    @NotBlank(message = "History is required")
    private String history;

    @Column
    private String image;

    @OneToMany(mappedBy = "character", targetEntity = StatCharacterEntity.class)
    private List<StatCharacterEntity> statCharacterRelation = new ArrayList<>();

}