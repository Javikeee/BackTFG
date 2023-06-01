package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.entity.StatCharacterEntity;
import com.profilePract.example.postgresql.entity.StatEnemyEntity;
import com.profilePract.example.postgresql.entity.StatEntity;
import com.profilePract.example.postgresql.entity.StatItemEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatEntityMother {

    public static StatEntity returnOne(){

        StatEntity statEntity = new StatEntity();
        statEntity.setId(1);
        statEntity.setName("a");

        List<StatCharacterEntity> statCharacterEntityList = new ArrayList<>();
        StatCharacterEntity statCharacterEntity = new StatCharacterEntity();
        statCharacterEntity.setId(1);
        statCharacterEntityList.add(statCharacterEntity);
        statEntity.setStatCharacterRelation(statCharacterEntityList);

        List<StatEnemyEntity> statEnemyEntityList = new ArrayList<>();
        StatEnemyEntity statEnemyEntity = new StatEnemyEntity();
        statEnemyEntity.setId(1);
        statEnemyEntityList.add(statEnemyEntity);
        statEntity.setStatEnemyRelation(statEnemyEntityList);

        List<StatItemEntity> statItemEntityList = new ArrayList<>();
        StatItemEntity statItemEntity = new StatItemEntity();
        statItemEntity.setId(1);
        statItemEntityList.add(statItemEntity);
        statEntity.setStatItemEntityRelation(statItemEntityList);

        return statEntity;
    }

    public static List<StatEntity> returnList(){
        return Collections.singletonList(returnOne());
    }

}