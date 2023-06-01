package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.StatEnemyDTO;
import com.profilePract.example.postgresql.entity.StatEnemyEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.StatEnemyRepository;
import com.profilePract.example.postgresql.service.StatEnemyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StatEnemyServiceImpl implements StatEnemyService {

    private final StatEnemyRepository statEnemyRepository;
    private final ObjectMapper mapper;

    @Override
    public List<StatEnemyDTO> findAll() {
        return mapper.map(statEnemyRepository.findAll(), StatEnemyDTO.class);
    }

    @Override
    public StatEnemyDTO getById(Integer id) {
        return mapper.map(statEnemyRepository.findById(id).orElse(null), StatEnemyDTO.class);
    }

    @Override
    public StatEnemyDTO create(StatEnemyDTO statDTO) {
        return mapper.map(statEnemyRepository.save(mapper.map(statDTO, StatEnemyEntity.class)), StatEnemyDTO.class);
    }

    @Override
    public StatEnemyDTO edit(StatEnemyDTO statDTO, Integer id) {
        return mapper.map(statEnemyRepository.findById(id).map(statEnemy -> {
            statEnemy = mapper.map(statDTO, StatEnemyEntity.class);
            statEnemy.setId(id);
            statEnemyRepository.save(statEnemy);
            return statEnemy;
        }).orElse(null), StatEnemyDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(statEnemyRepository.existsById(id)){
            statEnemyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
