package com.profilePract.example.postgresql.controller.impl;

import com.profilePract.example.postgresql.controller.CharacterAPI;
import com.profilePract.example.postgresql.controller.dto.CharacterDTO;
import com.profilePract.example.postgresql.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class CharacterController implements CharacterAPI {

    private final CharacterService characterService;

    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(characterService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return ResponseEntity.ok(characterService.getById(id));
    }

    @Override
    public ResponseEntity<?> create(CharacterDTO characterDTO) {
        CharacterDTO characterCreated = characterService.create(characterDTO);
        return ResponseEntity.ok(characterCreated);
    }

    @Override
    public ResponseEntity<?> edit(CharacterDTO characterDTO, Integer id) {
        if(characterDTO==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(characterService.edit(characterDTO, id));
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if(characterService.getById(id)!=null){
            boolean result = characterService.delete(id);
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
