package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.StatItemDTO;
import java.util.List;

public interface StatItemService {

    List<StatItemDTO> findAll();

    StatItemDTO getById(Integer id);

    StatItemDTO create(StatItemDTO statItemDTO);

    StatItemDTO edit(StatItemDTO statItemDTO, Integer id);

    boolean delete(Integer id);
}
