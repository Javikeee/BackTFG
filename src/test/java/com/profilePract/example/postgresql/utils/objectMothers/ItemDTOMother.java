package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.FloorItemDTO;
import com.profilePract.example.postgresql.controller.dto.ItemDTO;
import com.profilePract.example.postgresql.controller.dto.StatItemDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemDTOMother{

    public static ItemDTO returnOne(){

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(1);
        itemDTO.setDescription("a");
        itemDTO.setName("a");

        return itemDTO;
    }

    public static List<ItemDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}