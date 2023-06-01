package com.profilePract.example.postgresql.service.impl;


import com.profilePract.example.postgresql.controller.dto.CharacterDTO;
import com.profilePract.example.postgresql.entity.CharacterEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.CharacterRepository;
import com.profilePract.example.postgresql.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final ObjectMapper mapper;

    @Override
    public List<CharacterDTO> findAll() {
        return mapper.map(characterRepository.findAll(), CharacterDTO.class);
    }

    @Override
    public CharacterDTO getById(Integer id) {
        return mapper.map(characterRepository.findById(id).orElse(null), CharacterDTO.class);
    }

    @Override
    public CharacterDTO create(CharacterDTO characterDTO) {
        return mapper.map(
                characterRepository.save(
                        mapper.map(
                                characterDTO, CharacterEntity.class)
                ),
                CharacterDTO.class);
    }

    @Override
    public CharacterDTO edit(CharacterDTO characterDTO, Integer id) {
        return mapper.map(characterRepository.findById(id).map(pers -> {
            pers = mapper.map(characterDTO, CharacterEntity.class);
            pers.setId(id);
            characterRepository.save(pers);
            return pers;
        }).orElse(null), CharacterDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(characterRepository.existsById(id)){
            characterRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}