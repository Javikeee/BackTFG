package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;
import com.profilePract.example.postgresql.controller.dto.StatEnemyDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnemyDTOMother {

    public static EnemyDTO returnOne(){

        EnemyDTO enemyDTO = new EnemyDTO();
        enemyDTO.setId(1);
        enemyDTO.setName("Isaac");
        enemyDTO.setDescription("Abduzcan");

        StatEnemyDTO statEnemyDTO = new StatEnemyDTO();
        statEnemyDTO.setId(1);

        FloorEnemyDTO floorEnemyDTO = new FloorEnemyDTO();
        floorEnemyDTO.setId(1);

        return enemyDTO;
    }

    public static List<EnemyDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}