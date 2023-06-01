package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.EnemyAPI;
import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.service.EnemyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class EnemyController implements EnemyAPI {

    private final EnemyService enemyService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(enemyService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(enemyService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(EnemyDTO enemyDTO) {
        EnemyDTO enemyCreated = enemyService.create(enemyDTO);
        return ResponseEntity.ok(enemyCreated);
    }

    @Override
    public ResponseEntity<?> edit(EnemyDTO enemyDTO, Integer id) {
        if(enemyDTO==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(enemyService.edit(enemyDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if(enemyService.getById(id)!=null){
            boolean result = enemyService.delete(id);
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