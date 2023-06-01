package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import java.util.List;

public interface EnemyService {

    List<EnemyDTO> findAll();

    EnemyDTO getById(Integer id);

    EnemyDTO create(EnemyDTO enemyDTO);

    EnemyDTO edit(EnemyDTO enemyDTO, Integer id);

    boolean delete(Integer id);

}
