package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.controller.dto.StatDTO;
import com.profilePract.example.postgresql.controller.dto.StatEnemyDTO;

import java.util.Collections;
import java.util.List;

public class StatEnemyDTOMother {

    public static StatEnemyDTO returnOne(){

        StatEnemyDTO statEnemyDTO = new StatEnemyDTO();
        statEnemyDTO.setId(1);

        StatDTO statDTO = new StatDTO();
        statDTO.setId(1);
        statEnemyDTO.setStat(statDTO);

        EnemyDTO enemyDTO = new EnemyDTO();
        enemyDTO.setId(1);
        statEnemyDTO.setEnemy(enemyDTO);

        statEnemyDTO.setValue(1);

        return statEnemyDTO;
    }

    public static List<StatEnemyDTO> returnList(){
        return Collections.singletonList(returnOne());
    }

}
