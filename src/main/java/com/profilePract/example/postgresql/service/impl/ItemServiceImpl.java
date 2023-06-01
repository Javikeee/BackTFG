package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.ItemDTO;
import com.profilePract.example.postgresql.entity.ItemEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.ItemRepository;
import com.profilePract.example.postgresql.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ObjectMapper mapper;

    @Override
    public List<ItemDTO> findAll() {
        return mapper.map(itemRepository.findAll(), ItemDTO.class);
    }

    @Override
    public ItemDTO getById(Integer id) {
        return mapper.map(itemRepository.findById(id).orElse(null), ItemDTO.class);
    }

    @Override
    public ItemDTO create(ItemDTO itemDTO) {
        return mapper.map(itemRepository.save(mapper.map(itemDTO, ItemEntity.class)), ItemDTO.class);
    }

    @Override
    public ItemDTO edit(ItemDTO itemDTO, Integer id) {
        return mapper.map(itemRepository.findById(id).map(pers -> {
            pers = mapper.map(itemDTO, ItemEntity.class);
            pers.setId(id);
            itemRepository.save(pers);
            return pers;
        }).orElse(null), ItemDTO.class);
    }

    @Override
    public boolean delete(Integer id) {
        if(itemRepository.existsById(id)){
            itemRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}