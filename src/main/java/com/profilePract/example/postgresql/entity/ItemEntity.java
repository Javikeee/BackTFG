package com.profilePract.example.postgresql.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "t_item")
@Table(name = "t_item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank(message = "Name is required")
    private String name;

    @Column
    private String image;

    @Column
    @NotBlank(message = "Description is required")
    private String description;

    @OneToMany(mappedBy = "item", targetEntity = StatItemEntity.class)
    private List<StatItemEntity> statItemRelation = new ArrayList<>();

    @OneToMany(mappedBy = "item", targetEntity = FloorItemEntity.class)
    private List<FloorItemEntity> floorItemRelation = new ArrayList<>();
}
