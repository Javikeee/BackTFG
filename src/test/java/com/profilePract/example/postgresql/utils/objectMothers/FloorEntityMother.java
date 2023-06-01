package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.entity.FloorEntity;

import java.util.Collections;
import java.util.List;

public class FloorEntityMother {

    public static FloorEntity returnOne(){

        FloorEntity floorEntity = new FloorEntity();
        floorEntity.setId(1);
        floorEntity.setName("Basement");
        floorEntity.setFloorNumber(1);
        floorEntity.setDescription("Basic");

        return floorEntity;
    }

    public static List<FloorEntity> returnList(){
        return Collections.singletonList(returnOne());
    }
}