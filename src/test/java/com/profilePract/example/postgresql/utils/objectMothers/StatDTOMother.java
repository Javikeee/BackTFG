package com.profilePract.example.postgresql.utils.objectMothers;

import com.profilePract.example.postgresql.controller.dto.StatDTO;
import java.util.Collections;
import java.util.List;

public class StatDTOMother{

    public static StatDTO returnOne(){

        StatDTO statDTO = new StatDTO();
        statDTO.setId(1);
        statDTO.setName("a");

        return statDTO;
    }

    public static List<StatDTO> returnList(){
        return Collections.singletonList(returnOne());
    }

}