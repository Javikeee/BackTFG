package com.profilePract.example.postgresql.repository;

import com.profilePract.example.postgresql.entity.StatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends JpaRepository<StatEntity, Integer> {
}
