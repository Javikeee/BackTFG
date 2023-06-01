package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.FloorEnemyAPI;
import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;
import com.profilePract.example.postgresql.service.FloorEnemyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class FloorEnemyController implements FloorEnemyAPI {

    private final FloorEnemyService floorEnemyServiceService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(floorEnemyServiceService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(floorEnemyServiceService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(FloorEnemyDTO floorEnemyDTO) {
        FloorEnemyDTO floorEnemyCreated = floorEnemyServiceService.create(floorEnemyDTO);
        return ResponseEntity.ok(floorEnemyCreated);
    }

    @Override
    public ResponseEntity<?> edit(FloorEnemyDTO floorEnemyDTO, Integer id) {
        if (floorEnemyDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(floorEnemyServiceService.edit(floorEnemyDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (floorEnemyServiceService.getById(id) != null) {
            boolean result = floorEnemyServiceService.delete(id);
            if (!result) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.noContent().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
