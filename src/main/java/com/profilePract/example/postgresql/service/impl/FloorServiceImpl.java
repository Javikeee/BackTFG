package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.FloorDTO;
import com.profilePract.example.postgresql.entity.FloorEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.FloorRepository;
import com.profilePract.example.postgresql.service.FloorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class FloorServiceImpl implements FloorService {

    private final FloorRepository floorRepository;
    private final ObjectMapper mapper;

    @Override
    public List<FloorDTO> findAll() {
        return mapper.map(floorRepository.findAll(), FloorDTO.class);
    }

    @Override
    public FloorDTO getById(Integer id) {
        return mapper.map(floorRepository.findById(id).orElse(null), FloorDTO.class);
    }

    @Override
    public FloorDTO create(FloorDTO floorDTO) {
        System.out.println(floorDTO);
        return mapper.map(floorRepository.save(mapper.map(floorDTO, FloorEntity.class)), FloorDTO.class);
    }

    @Override
    public FloorDTO edit(FloorDTO floorDTO, Integer id) {
        return mapper.map(floorRepository.findById(id).map(pers -> {
            pers = mapper.map(floorDTO, FloorEntity.class);
            pers.setId(id);
            floorRepository.save(pers);
            return pers;
        }).orElse(null), FloorDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(floorRepository.existsById(id)){
            floorRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}