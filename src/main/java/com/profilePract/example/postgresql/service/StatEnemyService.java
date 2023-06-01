package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.StatEnemyDTO;
import java.util.List;

public interface StatEnemyService {

    List<StatEnemyDTO> findAll();

    StatEnemyDTO getById(Integer id);

    StatEnemyDTO create(StatEnemyDTO statEnemyDTO);

    StatEnemyDTO edit(StatEnemyDTO statEnemyDTO, Integer id);

    boolean delete(Integer id);
}
