package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.StatCharacterDTO;
import com.profilePract.example.postgresql.entity.StatCharacterEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.StatCharacterRepository;
import com.profilePract.example.postgresql.utils.objectMothers.StatCharacterDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.StatCharacterEntityMother;
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
public class StatCharacterServiceImplTest {

    @Mock
    private StatCharacterRepository statCharacterRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private StatCharacterServiceImpl statCharacterService;

    @Test
    void shouldReturnAllEnemiesTest() {
        List<StatCharacterDTO> statCharacterDTOList = StatCharacterDTOMother.returnList();
        List<StatCharacterEntity> statCharacterEntityList = StatCharacterEntityMother.returnList();

        Mockito.when(mapper.map(statCharacterEntityList, StatCharacterDTO.class)).thenReturn(statCharacterDTOList);
        Mockito.when(statCharacterRepository.findAll()).thenReturn(statCharacterEntityList);

        final List<StatCharacterDTO> result = statCharacterService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statCharacterDTOList, result);
        Mockito.verify(statCharacterRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(statCharacterEntityList, StatCharacterDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        StatCharacterDTO statCharacterDTO = StatCharacterDTOMother.returnOne();
        StatCharacterEntity statCharacterEntity = StatCharacterEntityMother.returnOne();

        Mockito.when(mapper.map(statCharacterDTO, StatCharacterEntity.class)).thenReturn(statCharacterEntity);
        Mockito.when(mapper.map(statCharacterDTO, StatCharacterEntity.class)).thenReturn(statCharacterEntity);
        Mockito.when(statCharacterRepository.save(statCharacterEntity)).thenReturn(statCharacterEntity);
        Mockito.when(mapper.map(statCharacterEntity, StatCharacterDTO.class)).thenReturn(statCharacterDTO);

        final StatCharacterDTO result = statCharacterService.create(statCharacterDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statCharacterDTO, result);
        Mockito.verify(statCharacterRepository).save(statCharacterEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        StatCharacterDTO expectedDto = StatCharacterDTOMother.returnOne();
        expectedDto.setValue(2);

        StatCharacterEntity expectedEntity = StatCharacterEntityMother.returnOne();
        expectedEntity.setValue(2);

        Mockito.when(statCharacterRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, StatCharacterEntity.class)).thenReturn(expectedEntity);
        Mockito.when(statCharacterRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, StatCharacterDTO.class)).thenReturn(expectedDto);

        final StatCharacterDTO result = statCharacterService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(statCharacterRepository).findById(1);
        Mockito.verify(statCharacterRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        StatCharacterEntity expectedEntity = StatCharacterEntityMother.returnOne();

        Mockito.when(statCharacterRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        statCharacterService.delete(1);

        final StatCharacterDTO result = statCharacterService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(statCharacterRepository).findById(1);

    }

}
