package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.EnemyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyRepository extends JpaRepository<EnemyEntity, Integer> {
}
