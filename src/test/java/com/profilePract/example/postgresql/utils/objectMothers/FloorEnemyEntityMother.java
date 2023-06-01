package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.entity.EnemyEntity;
import com.profilePract.example.postgresql.entity.FloorEnemyEntity;
import com.profilePract.example.postgresql.entity.FloorEntity;

import java.util.Collections;
import java.util.List;

public class FloorEnemyEntityMother {

    public static FloorEnemyEntity returnOne(){

        FloorEnemyEntity floorEnemyEntity = new FloorEnemyEntity();
        floorEnemyEntity.setId(1);

        EnemyEntity enemyEntity = new EnemyEntity();
        enemyEntity.setId(1);
        floorEnemyEntity.setEnemy(enemyEntity);

        FloorEntity floorEntity = new FloorEntity();
        floorEntity.setId(1);
        floorEnemyEntity.setFloor(floorEntity);

        return floorEnemyEntity;
    }

    public static List<FloorEnemyEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}