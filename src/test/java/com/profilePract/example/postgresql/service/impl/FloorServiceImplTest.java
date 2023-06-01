package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.FloorDTO;
import com.profilePract.example.postgresql.entity.FloorEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.FloorRepository;
import com.profilePract.example.postgresql.utils.objectMothers.FloorDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.FloorEntityMother;
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
public class FloorServiceImplTest {

    @Mock
    private FloorRepository floorRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private FloorServiceImpl floorService;

    @Test
    void shouldReturnAllEnemiesTest() {
        List<FloorDTO> floorDTOList = FloorDTOMother.returnList();
        List<FloorEntity> floorEntityList = FloorEntityMother.returnList();

        Mockito.when(mapper.map(floorEntityList, FloorDTO.class)).thenReturn(floorDTOList);
        Mockito.when(floorRepository.findAll()).thenReturn(floorEntityList);

        final List<FloorDTO> result = floorService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(floorDTOList, result);
        Mockito.verify(floorRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(floorEntityList, FloorDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        FloorDTO floorDTO = FloorDTOMother.returnOne();
        FloorEntity floorEntity = FloorEntityMother.returnOne();

        Mockito.when(mapper.map(floorDTO, FloorEntity.class)).thenReturn(floorEntity);
        Mockito.when(mapper.map(floorDTO, FloorEntity.class)).thenReturn(floorEntity);
        Mockito.when(floorRepository.save(floorEntity)).thenReturn(floorEntity);
        Mockito.when(mapper.map(floorEntity, FloorDTO.class)).thenReturn(floorDTO);

        final FloorDTO result = floorService.create(floorDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(floorDTO, result);
        Mockito.verify(floorRepository).save(floorEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        FloorDTO expectedDto = FloorDTOMother.returnOne();
        expectedDto.setDescription("b");

        FloorEntity expectedEntity = FloorEntityMother.returnOne();
        expectedEntity.setDescription("b");

        Mockito.when(floorRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, FloorEntity.class)).thenReturn(expectedEntity);
        Mockito.when(floorRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, FloorDTO.class)).thenReturn(expectedDto);

        final FloorDTO result = floorService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(floorRepository).findById(1);
        Mockito.verify(floorRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        FloorEntity expectedEntity = FloorEntityMother.returnOne();

        Mockito.when(floorRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        floorService.delete(1);

        final FloorDTO result = floorService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(floorRepository).findById(1);

    }
}