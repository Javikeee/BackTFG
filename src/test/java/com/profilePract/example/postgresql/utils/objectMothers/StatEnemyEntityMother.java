package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.controller.dto.FloorDTOMinified;
import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;
import com.profilePract.example.postgresql.entity.EnemyEntity;
import com.profilePract.example.postgresql.entity.StatEnemyEntity;
import com.profilePract.example.postgresql.entity.StatEntity;

import java.util.Collections;
import java.util.List;

public class StatEnemyEntityMother {

    public static StatEnemyEntity returnOne(){

        StatEnemyEntity statEnemyEntity = new StatEnemyEntity();
        statEnemyEntity.setId(1);

        StatEntity statEntity = new StatEntity();
        statEntity.setId(1);
        statEnemyEntity.setStat(statEntity);

        EnemyEntity enemyEntity = new EnemyEntity();
        enemyEntity.setId(1);
        statEnemyEntity.setEnemy(enemyEntity);

        statEnemyEntity.setValue(1);

        return statEnemyEntity;
    }

    public static List<StatEnemyEntity> returnList(){
        return Collections.singletonList(returnOne());
    }

}
