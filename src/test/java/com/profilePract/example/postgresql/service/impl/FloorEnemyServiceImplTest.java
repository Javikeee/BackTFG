package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;
import com.profilePract.example.postgresql.entity.EnemyEntity;
import com.profilePract.example.postgresql.entity.FloorEnemyEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.FloorEnemyRepository;
import com.profilePract.example.postgresql.utils.objectMothers.FloorEnemyDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.FloorEnemyEntityMother;
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
public class FloorEnemyServiceImplTest{
    
        @Mock
        private FloorEnemyRepository floorEnemyRepository;
        @Mock
        private ObjectMapper mapper;
        @InjectMocks
        private FloorEnemyServiceImpl floorEnemyService;

        @Test
        void shouldReturnAllEnemiesTest() {
            List<FloorEnemyDTO> floorEnemyDTOList = FloorEnemyDTOMother.returnList();
            List<FloorEnemyEntity> floorEnemyEntityList = FloorEnemyEntityMother.returnList();

            Mockito.when(mapper.map(floorEnemyEntityList, FloorEnemyDTO.class)).thenReturn(floorEnemyDTOList);
            Mockito.when(floorEnemyRepository.findAll()).thenReturn(floorEnemyEntityList);

            final List<FloorEnemyDTO> result = floorEnemyService.findAll();

            Assertions.assertNotNull(result);
            Assertions.assertEquals(floorEnemyDTOList, result);
            Mockito.verify(floorEnemyRepository, Mockito.times(1)).findAll();
            Mockito.verify(mapper).map(floorEnemyEntityList, FloorEnemyDTO.class);

        }

        @Test
        void shouldReturnCreateTest() {
            FloorEnemyDTO floorEnemyDTO = FloorEnemyDTOMother.returnOne();
            FloorEnemyEntity floorEnemyEntity = FloorEnemyEntityMother.returnOne();

            Mockito.when(mapper.map(floorEnemyDTO, FloorEnemyEntity.class)).thenReturn(floorEnemyEntity);
            Mockito.when(mapper.map(floorEnemyDTO, FloorEnemyEntity.class)).thenReturn(floorEnemyEntity);
            Mockito.when(floorEnemyRepository.save(floorEnemyEntity)).thenReturn(floorEnemyEntity);
            Mockito.when(mapper.map(floorEnemyEntity, FloorEnemyDTO.class)).thenReturn(floorEnemyDTO);

            final FloorEnemyDTO result = floorEnemyService.create(floorEnemyDTO);

            Assertions.assertNotNull(result);
            Assertions.assertEquals(floorEnemyDTO, result);
            Mockito.verify(floorEnemyRepository).save(floorEnemyEntity);
        }

        @Test
        void shouldReturnAnUpdateTest() {

            FloorEnemyDTO expectedDto = FloorEnemyDTOMother.returnOne();
            EnemyDTO enemyDTO = new EnemyDTO();
            enemyDTO.setId(2);
            expectedDto.setEnemy(enemyDTO);

            FloorEnemyEntity expectedEntity = FloorEnemyEntityMother.returnOne();
            EnemyEntity enemyEntity = new EnemyEntity();
            enemyEntity.setId(2);
            expectedEntity.setEnemy(enemyEntity);

            Mockito.when(floorEnemyRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
            Mockito.when(mapper.map(expectedDto, FloorEnemyEntity.class)).thenReturn(expectedEntity);
            Mockito.when(floorEnemyRepository.save(expectedEntity)).thenReturn(expectedEntity);
            Mockito.when(mapper.map(expectedEntity, FloorEnemyDTO.class)).thenReturn(expectedDto);

            final FloorEnemyDTO result = floorEnemyService.edit(expectedDto, 1);

            Assertions.assertNotNull(result);
            Assertions.assertEquals(expectedDto, result);
            Mockito.verify(floorEnemyRepository).findById(1);
            Mockito.verify(floorEnemyRepository).save(expectedEntity);
        }

        @Test
        void shouldDeleteTest() {

            FloorEnemyEntity expectedEntity = FloorEnemyEntityMother.returnOne();

            Mockito.when(floorEnemyRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

            floorEnemyService.delete(1);

            final FloorEnemyDTO result = floorEnemyService.getById(1);

            Assertions.assertNull(result);
            Mockito.verify(floorEnemyRepository).findById(1);

        }
}