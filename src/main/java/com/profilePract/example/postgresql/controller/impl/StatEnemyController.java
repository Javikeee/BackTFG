package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.StatEnemyAPI;
import com.profilePract.example.postgresql.controller.dto.StatEnemyDTO;
import com.profilePract.example.postgresql.service.StatEnemyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class StatEnemyController implements StatEnemyAPI {

    private final StatEnemyService StatEnemyService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(StatEnemyService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(StatEnemyService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(StatEnemyDTO StatEnemyDTO) {
        StatEnemyDTO StatEnemysCreated = StatEnemyService.create(StatEnemyDTO);
        return ResponseEntity.ok(StatEnemysCreated);
    }

    @Override
    public ResponseEntity<?> edit(StatEnemyDTO StatEnemyDTO, Integer id) {
        if(StatEnemyDTO ==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(StatEnemyService.edit(StatEnemyDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if(StatEnemyService.getById(id)!=null){
            boolean result = StatEnemyService.delete(id);
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
