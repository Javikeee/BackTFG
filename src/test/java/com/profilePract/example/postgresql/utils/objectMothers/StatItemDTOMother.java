package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.ItemDTO;
import com.profilePract.example.postgresql.controller.dto.StatDTO;
import com.profilePract.example.postgresql.controller.dto.StatItemDTO;

import java.util.Collections;
import java.util.List;

public class StatItemDTOMother {

    public static StatItemDTO returnOne(){

        StatItemDTO statItemDTO = new StatItemDTO();
        statItemDTO.setId(1);

        StatDTO statDTO = new StatDTO();
        statDTO.setId(1);
        statItemDTO.setStat(statDTO);

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(1);
        statItemDTO.setItem(itemDTO);

        statItemDTO.setValue(1);

        return statItemDTO;
    }

    public static List<StatItemDTO> returnList(){
        return Collections.singletonList(returnOne());
    }
}