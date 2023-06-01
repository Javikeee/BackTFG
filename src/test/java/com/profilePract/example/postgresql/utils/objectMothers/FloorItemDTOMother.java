package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.FloorDTOMinified;
import com.profilePract.example.postgresql.controller.dto.FloorItemDTO;
import com.profilePract.example.postgresql.controller.dto.ItemDTO;

import java.util.Collections;
import java.util.List;

public class FloorItemDTOMother {

    public static FloorItemDTO returnOne(){

        FloorItemDTO floorItemDTO = new FloorItemDTO();
        floorItemDTO.setId(1);

        FloorDTOMinified floorDTOMinified = new FloorDTOMinified();
        floorDTOMinified.setId(1);
        floorItemDTO.setFloor(floorDTOMinified);

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(1);
        floorItemDTO.setItem(itemDTO);

        return floorItemDTO;
    }

    public static List<FloorItemDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}