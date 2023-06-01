package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.CharacterDTO;
import com.profilePract.example.postgresql.controller.dto.StatCharacterDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterDTOMother {

    public static CharacterDTO returnOne(){

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(1);
        characterDTO.setName("Isaac");
        characterDTO.setHistory("His life was simple but one day his mother did a devil contract that make the rest of his life an hell");

        return characterDTO;
    }

    public static List<CharacterDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}