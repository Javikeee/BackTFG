package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.FloorItemDTO;

import java.util.List;

public interface FloorItemService {

    List<FloorItemDTO> findAll();

    FloorItemDTO getById(Integer id);

    FloorItemDTO create(FloorItemDTO floorItemDTO);

    FloorItemDTO edit(FloorItemDTO floorItemDTO, Integer id);

    boolean delete(Integer id);
}
