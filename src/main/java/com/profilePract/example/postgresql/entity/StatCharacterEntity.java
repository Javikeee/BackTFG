package com.profilePract.example.postgresql.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "t_statCharacter")
@Table(name = "t_statCharacter")
public class StatCharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stat")
    StatEntity stat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character")
    CharacterEntity character;

    @Column
    @NotBlank(message = "Value is required")
    private float value;

}