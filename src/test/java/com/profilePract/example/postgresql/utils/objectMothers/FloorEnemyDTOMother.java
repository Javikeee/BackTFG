package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.controller.dto.FloorDTOMinified;
import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;

import java.util.Collections;
import java.util.List;

public class FloorEnemyDTOMother {

    public static FloorEnemyDTO returnOne(){

        FloorEnemyDTO floorEnemyDTO = new FloorEnemyDTO();
        floorEnemyDTO.setId(1);

        EnemyDTO enemyDTO = new EnemyDTO();
        enemyDTO.setId(1);
        floorEnemyDTO.setEnemy(enemyDTO);

        FloorDTOMinified floorDTOMinified = new FloorDTOMinified();
        floorDTOMinified.setId(1);
        floorEnemyDTO.setFloor(floorDTOMinified);

        return floorEnemyDTO;
    }

    public static List<FloorEnemyDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}