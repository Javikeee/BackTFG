package com.profilePract.example.postgresql.service;


import com.profilePract.example.postgresql.controller.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> findAll();

    CharacterDTO getById(Integer id);

    CharacterDTO create(CharacterDTO characterDTO);

    CharacterDTO edit(CharacterDTO characterDTO, Integer id);

    boolean delete(Integer id);

}
