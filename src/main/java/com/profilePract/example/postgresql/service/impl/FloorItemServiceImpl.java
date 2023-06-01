package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.FloorItemDTO;
import com.profilePract.example.postgresql.entity.FloorItemEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.FloorItemRepository;
import com.profilePract.example.postgresql.service.FloorItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class FloorItemServiceImpl implements FloorItemService {

    private final FloorItemRepository floorItemRepository;
    private final ObjectMapper mapper;

    @Override
    public List<FloorItemDTO> findAll() {
        return mapper.map(floorItemRepository.findAll(), FloorItemDTO.class);
    }

    @Override
    public FloorItemDTO getById(Integer id) {
        return mapper.map(floorItemRepository.findById(id).orElse(null), FloorItemDTO.class);
    }

    @Override
    public FloorItemDTO create(FloorItemDTO floorItemDTO) {
        return mapper.map(floorItemRepository.save(mapper.map(floorItemDTO, FloorItemEntity.class)), FloorItemDTO.class);
    }

    @Override
    public FloorItemDTO edit(FloorItemDTO floorItemDTO, Integer id) {
        return mapper.map(floorItemRepository.findById(id).map(pers -> {
            pers = mapper.map(floorItemDTO, FloorItemEntity.class);
            pers.setId(id);
            floorItemRepository.save(pers);
            return pers;
        }).orElse(null), FloorItemDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(floorItemRepository.existsById(id)){
            floorItemRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}