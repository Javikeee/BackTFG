package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.FloorDTO;

import java.util.Collections;
import java.util.List;

public class FloorDTOMother{
    public static FloorDTO returnOne(){

        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setId(1);
        floorDTO.setName("Basement");
        floorDTO.setFloorNumber(1);
        floorDTO.setDescription("Basic");

        return floorDTO;
    }

    public static List<FloorDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}