package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.FloorEnemyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorEnemyRepository extends JpaRepository<FloorEnemyEntity, Integer> {
}
