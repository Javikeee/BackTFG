package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.FloorItemAPI;
import com.profilePract.example.postgresql.controller.dto.FloorItemDTO;
import com.profilePract.example.postgresql.service.FloorItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class FloorItemController implements FloorItemAPI {

    private final FloorItemService floorItemServiceService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(floorItemServiceService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(floorItemServiceService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(FloorItemDTO floorItemDTO) {
        FloorItemDTO floorItemCreated = floorItemServiceService.create(floorItemDTO);
        return ResponseEntity.ok(floorItemCreated);
    }

    @Override
    public ResponseEntity<?> edit(FloorItemDTO floorItemDTO, Integer id) {
        if (floorItemDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(floorItemServiceService.edit(floorItemDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (floorItemServiceService.getById(id) != null) {
            boolean result = floorItemServiceService.delete(id);
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
