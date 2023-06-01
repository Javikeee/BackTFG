package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.StatDTO;
import com.profilePract.example.postgresql.entity.StatEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.StatRepository;
import com.profilePract.example.postgresql.service.StatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final ObjectMapper mapper;

    @Override
    public List<StatDTO> findAll() {
        return mapper.map(statRepository.findAll(), StatDTO.class);
    }

    @Override
    public StatDTO getById(Integer id) {
        return mapper.map(statRepository.findById(id).orElse(null), StatDTO.class);
    }

    @Override
    public StatDTO create(StatDTO statDTO) {
        return mapper.map(statRepository.save(mapper.map(statDTO, StatEntity.class)), StatDTO.class);
    }

    @Override
    public StatDTO edit(StatDTO statDTO, Integer id) {
        return mapper.map(statRepository.findById(id).map(pers -> {
            pers = mapper.map(statDTO, StatEntity.class);
            pers.setId(id);
            statRepository.save(pers);
            return pers;
        }).orElse(null), StatDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(statRepository.existsById(id)){
            statRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}