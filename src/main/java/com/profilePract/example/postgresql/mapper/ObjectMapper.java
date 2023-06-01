package com.profilePract.example.postgresql.mapper;

import java.util.Collection;
import java.util.List;

public interface ObjectMapper {

    <D> D map(Object o, Class<D> clazz);


    <D> Collection<D> map(Collection<?> oList, Class<D> clazzDestino);


    <D> List<D> map(List<?> oList, Class<D> clazzDestino);

}

