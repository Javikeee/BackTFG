package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.StatCharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatCharacterRepository extends JpaRepository<StatCharacterEntity, Integer> {
}
