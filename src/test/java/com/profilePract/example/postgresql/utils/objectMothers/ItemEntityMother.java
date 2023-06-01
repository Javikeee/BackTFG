package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.entity.FloorItemEntity;
import com.profilePract.example.postgresql.entity.ItemEntity;
import com.profilePract.example.postgresql.entity.StatItemEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemEntityMother {

    public static ItemEntity returnOne(){

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(1);
        itemEntity.setDescription("a");
        itemEntity.setName("a");

        List<StatItemEntity> statItemEntityList = new ArrayList<>();
        StatItemEntity statItemEntity = new StatItemEntity();
        statItemEntity.setId(1);
        statItemEntityList.add(statItemEntity);
        itemEntity.setStatItemRelation(statItemEntityList);

        List<FloorItemEntity> floorItemEntityList = new ArrayList<>();
        FloorItemEntity floorItemEntity = new FloorItemEntity();
        floorItemEntity.setId(1);
        floorItemEntityList.add(floorItemEntity);
        itemEntity.setFloorItemRelation(floorItemEntityList);

        return itemEntity;
    }

    public static List<ItemEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}
