package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.StatItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatItemRepository extends JpaRepository<StatItemEntity, Integer> {
}
