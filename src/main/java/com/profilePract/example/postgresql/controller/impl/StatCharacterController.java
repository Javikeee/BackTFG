package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.StatCharacterAPI;
import com.profilePract.example.postgresql.controller.dto.StatCharacterDTO;
import com.profilePract.example.postgresql.service.StatCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class StatCharacterController implements StatCharacterAPI {

    private final StatCharacterService statCharacterService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(statCharacterService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(statCharacterService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(StatCharacterDTO statCharacterDTO) {
        StatCharacterDTO statCharactersCreated = statCharacterService.create(statCharacterDTO);
        return ResponseEntity.ok(statCharactersCreated);
    }

    @Override
    public ResponseEntity<?> edit(StatCharacterDTO statCharacterDTO, Integer id) {
        if(statCharacterDTO ==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(statCharacterService.edit(statCharacterDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if(statCharacterService.getById(id)!=null){
            boolean result = statCharacterService.delete(id);
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
