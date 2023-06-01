package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.FloorDTO;
import java.util.List;

public interface FloorService {

    List<FloorDTO> findAll();

    FloorDTO getById(Integer id);

    FloorDTO create(FloorDTO floorDTO);

    FloorDTO edit(FloorDTO floorDTO, Integer id);

    boolean delete(Integer id);

}
