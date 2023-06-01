package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.CharacterDTO;
import com.profilePract.example.postgresql.controller.dto.StatCharacterDTO;
import com.profilePract.example.postgresql.controller.dto.StatDTO;

import java.util.Collections;
import java.util.List;

public class StatCharacterDTOMother {

    public static StatCharacterDTO returnOne(){

        StatCharacterDTO statCharacterDTO = new StatCharacterDTO();
        statCharacterDTO.setId(1);

        StatDTO statDTO = new StatDTO();
        statDTO.setId(1);
        statCharacterDTO.setStat(statDTO);

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(1);
        statCharacterDTO.setCharacter(characterDTO);

        statCharacterDTO.setValue(1);

        return statCharacterDTO;
    }

    public static List<StatCharacterDTO> returnList(){
        return Collections.singletonList(returnOne());
    }

}