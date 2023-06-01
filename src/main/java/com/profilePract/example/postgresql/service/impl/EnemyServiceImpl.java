package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.entity.EnemyEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.EnemyRepository;
import com.profilePract.example.postgresql.service.EnemyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class EnemyServiceImpl implements EnemyService {

    private final EnemyRepository enemyRepository;
    private final ObjectMapper mapper;

    @Override
    public List<EnemyDTO> findAll() {
        return mapper.map(enemyRepository.findAll(), EnemyDTO.class);
    }

    @Override
    public EnemyDTO getById(Integer id) {
        return mapper.map(enemyRepository.findById(id).orElse(null), EnemyDTO.class);
    }

    @Override
    public EnemyDTO create(EnemyDTO enemyDTO) {
        return mapper.map(enemyRepository.save(mapper.map(enemyDTO, EnemyEntity.class)), EnemyDTO.class);
    }

    @Override
    public EnemyDTO edit(EnemyDTO enemyDTO, Integer id) {
        return mapper.map(enemyRepository.findById(id).map(pers -> {
            pers = mapper.map(enemyDTO, EnemyEntity.class);
            pers.setId(id);
            enemyRepository.save(pers);
            return pers;
        }).orElse(null), EnemyDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(enemyRepository.existsById(id)){
            enemyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}