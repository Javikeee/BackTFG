package com.profilePract.example.postgresql.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity(name = "t_floorEnemy")
@Table(name = "t_floorEnemy")
public class FloorEnemyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor")
    private FloorEntity floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enemy")
    private EnemyEntity enemy;

}
