package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<FloorEntity, Integer> {
}
