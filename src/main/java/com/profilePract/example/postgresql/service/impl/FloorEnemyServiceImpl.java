package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;
import com.profilePract.example.postgresql.entity.FloorEnemyEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.FloorEnemyRepository;
import com.profilePract.example.postgresql.service.FloorEnemyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class FloorEnemyServiceImpl implements FloorEnemyService {

    private final FloorEnemyRepository floorEnemyRepository;
    private final ObjectMapper mapper;

    @Override
    public List<FloorEnemyDTO> findAll() {
        return mapper.map(floorEnemyRepository.findAll(), FloorEnemyDTO.class);
    }

    @Override
    public FloorEnemyDTO getById(Integer id) {
        return mapper.map(floorEnemyRepository.findById(id).orElse(null), FloorEnemyDTO.class);
    }

    @Override
    public FloorEnemyDTO create(FloorEnemyDTO floorEnemyDTO) {
        return mapper.map(floorEnemyRepository.save(mapper.map(floorEnemyDTO, FloorEnemyEntity.class)), FloorEnemyDTO.class);
    }

    @Override
    public FloorEnemyDTO edit(FloorEnemyDTO floorEnemyDTO, Integer id) {
        return mapper.map(floorEnemyRepository.findById(id).map(pers -> {
            pers = mapper.map(floorEnemyDTO, FloorEnemyEntity.class);
            pers.setId(id);
            floorEnemyRepository.save(pers);
            return pers;
        }).orElse(null), FloorEnemyDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(floorEnemyRepository.existsById(id)){
            floorEnemyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}