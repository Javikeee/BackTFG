package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.ItemAPI;
import com.profilePract.example.postgresql.controller.dto.ItemDTO;
import com.profilePract.example.postgresql.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class ItemController implements ItemAPI {

    private final ItemService itemService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(itemService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(ItemDTO itemDTO) {
        ItemDTO itemCreated = itemService.create(itemDTO);
        return ResponseEntity.ok(itemCreated);
    }

    @Override
    public ResponseEntity<?> edit(ItemDTO itemDTO, Integer id) {
        if(itemDTO==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(itemService.edit(itemDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if(itemService.getById(id)!=null){
            boolean result = itemService.delete(id);
            if (!result) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.noContent().build();
            }
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
