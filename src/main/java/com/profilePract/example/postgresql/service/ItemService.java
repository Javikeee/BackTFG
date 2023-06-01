package com.profilePract.example.postgresql.service;

import com.profilePract.example.postgresql.controller.dto.ItemDTO;
import java.util.List;

public interface ItemService {

    List<ItemDTO> findAll();

    ItemDTO getById(Integer id);

    ItemDTO create(ItemDTO itemDTO);

    ItemDTO edit(ItemDTO itemDTO, Integer id);

    boolean delete(Integer id);

}
