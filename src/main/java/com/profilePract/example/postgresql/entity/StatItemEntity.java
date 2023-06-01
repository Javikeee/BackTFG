package com.profilePract.example.postgresql.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity(name = "t_statItem")
@Table(name = "t_statItem")
public class StatItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stat")
    StatEntity stat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item")
    ItemEntity item;

    @Column
    @NotBlank(message = "Value is required")
    private float value;

}
