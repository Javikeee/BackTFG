package com.profilePract.example.postgresql.service.impl;

import com.profilePract.example.postgresql.controller.dto.StatItemDTO;
import com.profilePract.example.postgresql.entity.StatItemEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.StatItemRepository;
import com.profilePract.example.postgresql.utils.objectMothers.StatItemDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.StatItemEntityMother;
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
public class StatItemServiceImplTest {

    @Mock
    private StatItemRepository statItemRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private StatItemServiceImpl statItemService;

    @Test
    void shouldReturnAllEnemiesTest() {
        List<StatItemDTO> statItemDTOList = StatItemDTOMother.returnList();
        List<StatItemEntity> statItemEntityList = StatItemEntityMother.returnList();

        Mockito.when(mapper.map(statItemEntityList, StatItemDTO.class)).thenReturn(statItemDTOList);
        Mockito.when(statItemRepository.findAll()).thenReturn(statItemEntityList);

        final List<StatItemDTO> result = statItemService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statItemDTOList, result);
        Mockito.verify(statItemRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(statItemEntityList, StatItemDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        StatItemDTO statItemDTO = StatItemDTOMother.returnOne();
        StatItemEntity statItemEntity = StatItemEntityMother.returnOne();

        Mockito.when(mapper.map(statItemDTO, StatItemEntity.class)).thenReturn(statItemEntity);
        Mockito.when(mapper.map(statItemDTO, StatItemEntity.class)).thenReturn(statItemEntity);
        Mockito.when(statItemRepository.save(statItemEntity)).thenReturn(statItemEntity);
        Mockito.when(mapper.map(statItemEntity, StatItemDTO.class)).thenReturn(statItemDTO);

        final StatItemDTO result = statItemService.create(statItemDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statItemDTO, result);
        Mockito.verify(statItemRepository).save(statItemEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        StatItemDTO expectedDto = StatItemDTOMother.returnOne();
        expectedDto.setValue(2);

        StatItemEntity expectedEntity = StatItemEntityMother.returnOne();
        expectedEntity.setValue(2);

        Mockito.when(statItemRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, StatItemEntity.class)).thenReturn(expectedEntity);
        Mockito.when(statItemRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, StatItemDTO.class)).thenReturn(expectedDto);

        final StatItemDTO result = statItemService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(statItemRepository).findById(1);
        Mockito.verify(statItemRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        StatItemEntity expectedEntity = StatItemEntityMother.returnOne();

        Mockito.when(statItemRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        statItemService.delete(1);

        final StatItemDTO result = statItemService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(statItemRepository).findById(1);

    }


}
