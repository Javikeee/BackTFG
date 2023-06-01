package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.StatDTO;
import com.profilePract.example.postgresql.entity.StatEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.StatRepository;
import com.profilePract.example.postgresql.utils.objectMothers.StatDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.StatEntityMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StatServiceImplTest {

    @Mock
    private StatRepository statRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private StatServiceImpl statService;

    @Test
    void shouldReturnAllEnemiesTest() {
        List<StatDTO> statDTOList = StatDTOMother.returnList();
        List<StatEntity> statEntityList = StatEntityMother.returnList();

        Mockito.when(mapper.map(statEntityList, StatDTO.class)).thenReturn(statDTOList);
        Mockito.when(statRepository.findAll()).thenReturn(statEntityList);

        final List<StatDTO> result = statService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statDTOList, result);
        Mockito.verify(statRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(statEntityList, StatDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        StatDTO statDTO = StatDTOMother.returnOne();
        StatEntity statEntity = StatEntityMother.returnOne();

        Mockito.when(mapper.map(statDTO, StatEntity.class)).thenReturn(statEntity);
        Mockito.when(mapper.map(statDTO, StatEntity.class)).thenReturn(statEntity);
        Mockito.when(statRepository.save(statEntity)).thenReturn(statEntity);
        Mockito.when(mapper.map(statEntity, StatDTO.class)).thenReturn(statDTO);

        final StatDTO result = statService.create(statDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statDTO, result);
        Mockito.verify(statRepository).save(statEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        StatDTO expectedDto = StatDTOMother.returnOne();
        expectedDto.setName("b");

        StatEntity expectedEntity = StatEntityMother.returnOne();
        expectedEntity.setName("b");

        Mockito.when(statRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, StatEntity.class)).thenReturn(expectedEntity);
        Mockito.when(statRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, StatDTO.class)).thenReturn(expectedDto);

        final StatDTO result = statService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(statRepository).findById(1);
        Mockito.verify(statRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        StatEntity expectedEntity = StatEntityMother.returnOne();

        Mockito.when(statRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        statService.delete(1);

        final StatDTO result = statService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(statRepository).findById(1);

    }
    
}