package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;
import java.util.List;

public interface FloorEnemyService {

    List<FloorEnemyDTO> findAll();

    FloorEnemyDTO getById(Integer id);

    FloorEnemyDTO create(FloorEnemyDTO floorEnemyDTO);

    FloorEnemyDTO edit(FloorEnemyDTO floorEnemyDTO, Integer id);

    boolean delete(Integer id);
}
