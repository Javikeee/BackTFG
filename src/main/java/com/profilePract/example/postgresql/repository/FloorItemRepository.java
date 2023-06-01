package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.FloorItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorItemRepository extends JpaRepository<FloorItemEntity, Integer> {
}
