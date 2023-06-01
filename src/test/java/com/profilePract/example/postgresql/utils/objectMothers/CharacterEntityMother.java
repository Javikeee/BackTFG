package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.entity.CharacterEntity;
import com.profilePract.example.postgresql.entity.StatCharacterEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterEntityMother {

    public static CharacterEntity returnOne(){

        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(1);
        characterEntity.setName("Isaac");
        characterEntity.setHistory("His life was simple but one day his mother did a devil contract that make the rest of his life an hell");

        StatCharacterEntity statCharacterEntity = new StatCharacterEntity();
        statCharacterEntity.setId(1);

        List<StatCharacterEntity> statCharacterEntityList = new ArrayList<>();
        statCharacterEntityList.add(statCharacterEntity);

        characterEntity.setStatCharacterRelation(statCharacterEntityList);

        return characterEntity;
    }

    public static List<CharacterEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}