package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.entity.FloorEntity;
import com.profilePract.example.postgresql.entity.FloorItemEntity;
import com.profilePract.example.postgresql.entity.ItemEntity;

import java.util.Collections;
import java.util.List;

public class FloorItemEntityMother {

    public static FloorItemEntity returnOne(){

        FloorItemEntity floorItemEntity = new FloorItemEntity();
        floorItemEntity.setId(1);

        FloorEntity floor = new FloorEntity();
        floor.setId(1);
        floorItemEntity.setFloor(floor);

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(1);
        floorItemEntity.setItem(itemEntity);

        return floorItemEntity;
    }

    public static List<FloorItemEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}