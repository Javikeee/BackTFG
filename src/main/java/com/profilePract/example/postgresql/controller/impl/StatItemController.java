package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.StatItemAPI;
import com.profilePract.example.postgresql.controller.dto.StatItemDTO;
import com.profilePract.example.postgresql.service.StatItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class StatItemController implements StatItemAPI {

    private final StatItemService StatItemService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(StatItemService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(StatItemService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(StatItemDTO StatItemDTO) {
        StatItemDTO StatItemsCreated = StatItemService.create(StatItemDTO);
        return ResponseEntity.ok(StatItemsCreated);
    }

    @Override
    public ResponseEntity<?> edit(StatItemDTO StatItemDTO, Integer id) {
        if(StatItemDTO ==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(StatItemService.edit(StatItemDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if(StatItemService.getById(id)!=null){
            boolean result = StatItemService.delete(id);
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
