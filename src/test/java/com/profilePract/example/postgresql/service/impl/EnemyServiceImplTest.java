package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.entity.EnemyEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.EnemyRepository;
import com.profilePract.example.postgresql.utils.objectMothers.EnemyDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.EnemyEntityMother;
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
public class EnemyServiceImplTest {

    @Mock
    private EnemyRepository enemyRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private EnemyServiceImpl enemyService;

    @Test
    void shouldReturnAllEnemiesTest() {
        List<EnemyDTO> enemyDTOList = EnemyDTOMother.returnList();
        List<EnemyEntity> enemyEntityList = EnemyEntityMother.returnList();

        Mockito.when(mapper.map(enemyEntityList, EnemyDTO.class)).thenReturn(enemyDTOList);
        Mockito.when(enemyRepository.findAll()).thenReturn(enemyEntityList);

        final List<EnemyDTO> result = enemyService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(enemyDTOList, result);
        Mockito.verify(enemyRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(enemyEntityList, EnemyDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        EnemyDTO enemyDTO = EnemyDTOMother.returnOne();
        EnemyEntity enemyEntity = EnemyEntityMother.returnOne();

        Mockito.when(mapper.map(enemyDTO, EnemyEntity.class)).thenReturn(enemyEntity);
        Mockito.when(mapper.map(enemyDTO, EnemyEntity.class)).thenReturn(enemyEntity);
        Mockito.when(enemyRepository.save(enemyEntity)).thenReturn(enemyEntity);
        Mockito.when(mapper.map(enemyEntity, EnemyDTO.class)).thenReturn(enemyDTO);

        final EnemyDTO result = enemyService.create(enemyDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(enemyDTO, result);
        Mockito.verify(enemyRepository).save(enemyEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        EnemyDTO expectedDto = EnemyDTOMother.returnOne();
        expectedDto.setName("Manolo");

        EnemyEntity expectedEntity = EnemyEntityMother.returnOne();
        expectedEntity.setName("Manolo");

        Mockito.when(enemyRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, EnemyEntity.class)).thenReturn(expectedEntity);
        Mockito.when(enemyRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, EnemyDTO.class)).thenReturn(expectedDto);

        final EnemyDTO result = enemyService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(enemyRepository).findById(1);
        Mockito.verify(enemyRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        EnemyEntity expectedEntity = EnemyEntityMother.returnOne();

        Mockito.when(enemyRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        enemyService.delete(1);

        final EnemyDTO result = enemyService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(enemyRepository).findById(1);

    }
}