package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.StatCharacterDTO;
import com.profilePract.example.postgresql.entity.StatCharacterEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.StatCharacterRepository;
import com.profilePract.example.postgresql.service.StatCharacterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class StatCharacterServiceImpl implements StatCharacterService {

    private final StatCharacterRepository statCharacterRepository;
    private final ObjectMapper mapper;

    @Override
    public List<StatCharacterDTO> findAll() {
        return mapper.map(statCharacterRepository.findAll(), StatCharacterDTO.class);
    }

    @Override
    public StatCharacterDTO getById(Integer id) {
        return mapper.map(statCharacterRepository.findById(id).orElse(null), StatCharacterDTO.class);
    }

    @Override
    public StatCharacterDTO create(StatCharacterDTO statDTO) {
        return mapper.map(statCharacterRepository.save(mapper.map(statDTO, StatCharacterEntity.class)), StatCharacterDTO.class);
    }

    @Override
    public StatCharacterDTO edit(StatCharacterDTO statDTO, Integer id) {
        return mapper.map(statCharacterRepository.findById(id).map(statCharacter -> {
            statCharacter = mapper.map(statDTO, StatCharacterEntity.class);
            statCharacter.setId(id);
            statCharacterRepository.save(statCharacter);
            return statCharacter;
        }).orElse(null), StatCharacterDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(statCharacterRepository.existsById(id)){
            statCharacterRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
