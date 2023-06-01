package com.profilePract.example.postgresql.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "t_statEnemy")
@Table(name = "t_statEnemy")
public class StatEnemyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stat")
    StatEntity stat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enemy")
    EnemyEntity enemy;

    @Column
    @NotBlank(message = "Value is required")
    private float value;

}
