package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.StatEnemyDTO;
import com.profilePract.example.postgresql.entity.StatEnemyEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.StatEnemyRepository;
import com.profilePract.example.postgresql.utils.objectMothers.StatEnemyDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.StatEnemyEntityMother;
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
public class StatEnemyServiceImplTest {

    @Mock
    private StatEnemyRepository statEnemyRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private StatEnemyServiceImpl statEnemyService;

    @Test
    void shouldReturnAllEnemiesTest() {
        List<StatEnemyDTO> statEnemyDTOList = StatEnemyDTOMother.returnList();
        List<StatEnemyEntity> statEnemyEntityList = StatEnemyEntityMother.returnList();

        Mockito.when(mapper.map(statEnemyEntityList, StatEnemyDTO.class)).thenReturn(statEnemyDTOList);
        Mockito.when(statEnemyRepository.findAll()).thenReturn(statEnemyEntityList);

        final List<StatEnemyDTO> result = statEnemyService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statEnemyDTOList, result);
        Mockito.verify(statEnemyRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(statEnemyEntityList, StatEnemyDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        StatEnemyDTO statEnemyDTO = StatEnemyDTOMother.returnOne();
        StatEnemyEntity statEnemyEntity = StatEnemyEntityMother.returnOne();

        Mockito.when(mapper.map(statEnemyDTO, StatEnemyEntity.class)).thenReturn(statEnemyEntity);
        Mockito.when(mapper.map(statEnemyDTO, StatEnemyEntity.class)).thenReturn(statEnemyEntity);
        Mockito.when(statEnemyRepository.save(statEnemyEntity)).thenReturn(statEnemyEntity);
        Mockito.when(mapper.map(statEnemyEntity, StatEnemyDTO.class)).thenReturn(statEnemyDTO);

        final StatEnemyDTO result = statEnemyService.create(statEnemyDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statEnemyDTO, result);
        Mockito.verify(statEnemyRepository).save(statEnemyEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        StatEnemyDTO expectedDto = StatEnemyDTOMother.returnOne();
        expectedDto.setValue(2);

        StatEnemyEntity expectedEntity = StatEnemyEntityMother.returnOne();
        expectedEntity.setValue(2);

        Mockito.when(statEnemyRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, StatEnemyEntity.class)).thenReturn(expectedEntity);
        Mockito.when(statEnemyRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, StatEnemyDTO.class)).thenReturn(expectedDto);

        final StatEnemyDTO result = statEnemyService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(statEnemyRepository).findById(1);
        Mockito.verify(statEnemyRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        StatEnemyEntity expectedEntity = StatEnemyEntityMother.returnOne();

        Mockito.when(statEnemyRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        statEnemyService.delete(1);

        final StatEnemyDTO result = statEnemyService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(statEnemyRepository).findById(1);

    }


}
