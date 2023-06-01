package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.ItemDTO;
import com.profilePract.example.postgresql.entity.ItemEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.ItemRepository;
import com.profilePract.example.postgresql.utils.objectMothers.ItemDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.ItemEntityMother;
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
public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    void shouldReturnAllEnemiesTest() {
        List<ItemDTO> itemDTOList = ItemDTOMother.returnList();
        List<ItemEntity> itemEntityList = ItemEntityMother.returnList();

        Mockito.when(mapper.map(itemEntityList, ItemDTO.class)).thenReturn(itemDTOList);
        Mockito.when(itemRepository.findAll()).thenReturn(itemEntityList);

        final List<ItemDTO> result = itemService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(itemDTOList, result);
        Mockito.verify(itemRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(itemEntityList, ItemDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        ItemDTO itemDTO = ItemDTOMother.returnOne();
        ItemEntity itemEntity = ItemEntityMother.returnOne();

        Mockito.when(mapper.map(itemDTO, ItemEntity.class)).thenReturn(itemEntity);
        Mockito.when(mapper.map(itemDTO, ItemEntity.class)).thenReturn(itemEntity);
        Mockito.when(itemRepository.save(itemEntity)).thenReturn(itemEntity);
        Mockito.when(mapper.map(itemEntity, ItemDTO.class)).thenReturn(itemDTO);

        final ItemDTO result = itemService.create(itemDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(itemDTO, result);
        Mockito.verify(itemRepository).save(itemEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        ItemDTO expectedDto = ItemDTOMother.returnOne();
        expectedDto.setDescription("b");

        ItemEntity expectedEntity = ItemEntityMother.returnOne();
        expectedEntity.setDescription("b");

        Mockito.when(itemRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, ItemEntity.class)).thenReturn(expectedEntity);
        Mockito.when(itemRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, ItemDTO.class)).thenReturn(expectedDto);

        final ItemDTO result = itemService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(itemRepository).findById(1);
        Mockito.verify(itemRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        ItemEntity expectedEntity = ItemEntityMother.returnOne();

        Mockito.when(itemRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        itemService.delete(1);

        final ItemDTO result = itemService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(itemRepository).findById(1);

    }
    
}