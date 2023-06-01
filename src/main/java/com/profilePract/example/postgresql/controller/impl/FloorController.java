package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.FloorAPI;
import com.profilePract.example.postgresql.controller.dto.FloorDTO;
import com.profilePract.example.postgresql.service.FloorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class FloorController implements FloorAPI {

    private final FloorService floorService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(floorService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(floorService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(FloorDTO floorDTO) {
        FloorDTO floorCreated = floorService.create(floorDTO);
        return ResponseEntity.ok(floorCreated);
    }

    @Override
    public ResponseEntity<?> edit(FloorDTO floorDTO, Integer id) {
        if(floorDTO==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(floorService.edit(floorDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if(floorService.getById(id)!=null){
            boolean result = floorService.delete(id);
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