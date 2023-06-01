package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.StatEnemyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatEnemyRepository extends JpaRepository<StatEnemyEntity, Integer> {
}
