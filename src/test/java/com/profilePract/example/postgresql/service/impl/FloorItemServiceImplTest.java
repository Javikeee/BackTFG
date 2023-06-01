package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.FloorItemDTO;
import com.profilePract.example.postgresql.controller.dto.ItemDTO;
import com.profilePract.example.postgresql.entity.FloorItemEntity;
import com.profilePract.example.postgresql.entity.ItemEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.FloorItemRepository;
import com.profilePract.example.postgresql.utils.objectMothers.FloorItemDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.FloorItemEntityMother;
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
public class FloorItemServiceImplTest  {

    @Mock
    private FloorItemRepository floorItemRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private FloorItemServiceImpl floorItemService;

    @Test
    void shouldReturnAllEnemiesTest() {
        List<FloorItemDTO> floorItemDTOList = FloorItemDTOMother.returnList();
        List<FloorItemEntity> floorItemEntityList = FloorItemEntityMother.returnList();

        Mockito.when(mapper.map(floorItemEntityList, FloorItemDTO.class)).thenReturn(floorItemDTOList);
        Mockito.when(floorItemRepository.findAll()).thenReturn(floorItemEntityList);

        final List<FloorItemDTO> result = floorItemService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(floorItemDTOList, result);
        Mockito.verify(floorItemRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(floorItemEntityList, FloorItemDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        FloorItemDTO floorItemDTO = FloorItemDTOMother.returnOne();
        FloorItemEntity floorItemEntity = FloorItemEntityMother.returnOne();

        Mockito.when(mapper.map(floorItemDTO, FloorItemEntity.class)).thenReturn(floorItemEntity);
        Mockito.when(mapper.map(floorItemDTO, FloorItemEntity.class)).thenReturn(floorItemEntity);
        Mockito.when(floorItemRepository.save(floorItemEntity)).thenReturn(floorItemEntity);
        Mockito.when(mapper.map(floorItemEntity, FloorItemDTO.class)).thenReturn(floorItemDTO);

        final FloorItemDTO result = floorItemService.create(floorItemDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(floorItemDTO, result);
        Mockito.verify(floorItemRepository).save(floorItemEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        FloorItemDTO expectedDto = FloorItemDTOMother.returnOne();
        ItemDTO ItemDTO = new ItemDTO();
        ItemDTO.setId(2);
        expectedDto.setItem(ItemDTO);

        FloorItemEntity expectedEntity = FloorItemEntityMother.returnOne();
        ItemEntity ItemEntity = new ItemEntity();
        ItemEntity.setId(2);
        expectedEntity.setItem(ItemEntity);

        Mockito.when(floorItemRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, FloorItemEntity.class)).thenReturn(expectedEntity);
        Mockito.when(floorItemRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, FloorItemDTO.class)).thenReturn(expectedDto);

        final FloorItemDTO result = floorItemService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(floorItemRepository).findById(1);
        Mockito.verify(floorItemRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        FloorItemEntity expectedEntity = FloorItemEntityMother.returnOne();

        Mockito.when(floorItemRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        floorItemService.delete(1);

        final FloorItemDTO result = floorItemService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(floorItemRepository).findById(1);

    }
    
}