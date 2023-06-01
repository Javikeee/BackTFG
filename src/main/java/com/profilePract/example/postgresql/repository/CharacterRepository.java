package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
}
