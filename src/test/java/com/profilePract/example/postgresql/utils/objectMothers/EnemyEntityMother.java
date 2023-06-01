package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.entity.EnemyEntity;
import com.profilePract.example.postgresql.entity.FloorEnemyEntity;
import com.profilePract.example.postgresql.entity.StatEnemyEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnemyEntityMother {

    public static EnemyEntity returnOne(){

        EnemyEntity enemyEntity = new EnemyEntity();
        enemyEntity.setId(1);
        enemyEntity.setName("Isaac");
        enemyEntity.setDescription("Abduzcan");

        StatEnemyEntity statEnemyEntity = new StatEnemyEntity();
        statEnemyEntity.setId(1);

        List<StatEnemyEntity> statEnemyEntityList = new ArrayList<>();
        statEnemyEntityList.add(statEnemyEntity);

        enemyEntity.setStatEnemyRelation(statEnemyEntityList);

        FloorEnemyEntity floorEnemyEntity = new FloorEnemyEntity();
        floorEnemyEntity.setId(1);

        List<FloorEnemyEntity> floorEnemyEntityList = new ArrayList<>();
        floorEnemyEntityList.add(floorEnemyEntity);

        enemyEntity.setFloorEnemyRelation(floorEnemyEntityList);

        return enemyEntity;
    }

    public static List<EnemyEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}