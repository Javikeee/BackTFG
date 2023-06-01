package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.controller.dto.FloorDTOMinified;
import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;
import com.profilePract.example.postgresql.entity.ItemEntity;
import com.profilePract.example.postgresql.entity.StatEntity;
import com.profilePract.example.postgresql.entity.StatItemEntity;

import java.util.Collections;
import java.util.List;

public class StatItemEntityMother {

    public static StatItemEntity returnOne(){

        StatItemEntity statItemEntity = new StatItemEntity();
        statItemEntity.setId(1);

        StatEntity statEntity = new StatEntity();
        statEntity.setId(1);
        statItemEntity.setStat(statEntity);

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(1);
        statItemEntity.setItem(itemEntity);

        statItemEntity.setValue(1);

        return statItemEntity;
    }

    public static List<StatItemEntity> returnList(){
        return Collections.singletonList(returnOne());
    }

}
