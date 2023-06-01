package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.entity.CharacterEntity;
import com.profilePract.example.postgresql.entity.StatCharacterEntity;
import com.profilePract.example.postgresql.entity.StatEntity;

import java.util.Collections;
import java.util.List;

public class StatCharacterEntityMother {

    public static StatCharacterEntity returnOne(){

        StatCharacterEntity statCharacterEntity = new StatCharacterEntity();
        statCharacterEntity.setId(1);

        StatEntity statEntity = new StatEntity();
        statEntity.setId(1);
        statCharacterEntity.setStat(statEntity);

        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(1);
        statCharacterEntity.setCharacter(characterEntity);

        statCharacterEntity.setValue(1);

        return statCharacterEntity;
    }

    public static List<StatCharacterEntity> returnList(){
        return Collections.singletonList(returnOne());
    }

}