package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.StatItemDTO;
import com.profilePract.example.postgresql.entity.StatItemEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.StatItemRepository;
import com.profilePract.example.postgresql.service.StatItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StatItemServiceImpl implements StatItemService {

    private final StatItemRepository statItemRepository;
    private final ObjectMapper mapper;

    @Override
        public List<StatItemDTO> findAll() {
        return mapper.map(statItemRepository.findAll(), StatItemDTO.class);
    }

    @Override
    public StatItemDTO getById(Integer id) {
        return mapper.map(statItemRepository.findById(id).orElse(null), StatItemDTO.class);
    }

    @Override
    public StatItemDTO create(StatItemDTO statDTO) {
        return mapper.map(statItemRepository.save(mapper.map(statDTO, StatItemEntity.class)), StatItemDTO.class);
    }

    @Override
    public StatItemDTO edit(StatItemDTO statDTO, Integer id) {
        return mapper.map(statItemRepository.findById(id).map(statItem -> {
            statItem = mapper.map(statDTO, StatItemEntity.class);
            statItem.setId(id);
            statItemRepository.save(statItem);
            return statItem;
        }).orElse(null), StatItemDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(statItemRepository.existsById(id)){
            statItemRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
