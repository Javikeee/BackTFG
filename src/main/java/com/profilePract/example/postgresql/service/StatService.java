package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.StatDTO;
import java.util.List;

public interface StatService {

    List<StatDTO> findAll();

    StatDTO getById(Integer id);

    StatDTO create(StatDTO statDTO);

    StatDTO edit(StatDTO statDTO, Integer id);

    boolean delete(Integer id);

}
