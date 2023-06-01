package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.StatCharacterDTO;
import java.util.List;

public interface StatCharacterService {

    List<StatCharacterDTO> findAll();

    StatCharacterDTO getById(Integer id);

    StatCharacterDTO create(StatCharacterDTO statCharacterDTO);

    StatCharacterDTO edit(StatCharacterDTO statCharacterDTO, Integer id);

    boolean delete(Integer id);
}
