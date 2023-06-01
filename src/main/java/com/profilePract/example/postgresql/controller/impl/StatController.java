package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.StatAPI;
import com.profilePract.example.postgresql.controller.dto.StatDTO;
import com.profilePract.example.postgresql.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class StatController implements StatAPI {

    private final StatService statService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(statService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(statService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(StatDTO statDTO) {
        StatDTO statsCreated = statService.create(statDTO);
        return ResponseEntity.ok(statsCreated);
    }

    @Override
    public ResponseEntity<?> edit(StatDTO statDTO, Integer id) {
        if(statDTO ==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(statService.edit(statDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if(statService.getById(id)!=null){
            boolean result = statService.delete(id);
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
