package com.profilePract.example.postgresql.service.impl;


import com.profilePract.example.postgresql.controller.dto.CharacterDTO;
import com.profilePract.example.postgresql.entity.CharacterEntity;
import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.repository.CharacterRepository;
import com.profilePract.example.postgresql.utils.objectMothers.CharacterDTOMother;
import com.profilePract.example.postgresql.utils.objectMothers.CharacterEntityMother;
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
public class CharacterServiceImplTest {

    @Mock
    private CharacterRepository characterRepository;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private CharacterServiceImpl characterService;

    @Test
    void shouldReturnAllCharactersTest() {
        List<CharacterDTO> characterDTOList = CharacterDTOMother.returnList();
        List<CharacterEntity> characterEntityList = CharacterEntityMother.returnList();

        Mockito.when(mapper.map(characterEntityList, CharacterDTO.class)).thenReturn(characterDTOList);
        Mockito.when(characterRepository.findAll()).thenReturn(characterEntityList);

        final List<CharacterDTO> result = characterService.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(characterDTOList, result);
        Mockito.verify(characterRepository, Mockito.times(1)).findAll();
        Mockito.verify(mapper).map(characterEntityList, CharacterDTO.class);

    }

    @Test
    void shouldReturnCreateTest() {
        CharacterDTO characterDTO = CharacterDTOMother.returnOne();
        CharacterEntity characterEntity = CharacterEntityMother.returnOne();

        Mockito.when(mapper.map(characterDTO, CharacterEntity.class)).thenReturn(characterEntity);
        Mockito.when(mapper.map(characterDTO, CharacterEntity.class)).thenReturn(characterEntity);
        Mockito.when(characterRepository.save(characterEntity)).thenReturn(characterEntity);
        Mockito.when(mapper.map(characterEntity, CharacterDTO.class)).thenReturn(characterDTO);

        final CharacterDTO result = characterService.create(characterDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(characterDTO, result);
        Mockito.verify(characterRepository).save(characterEntity);
    }

    @Test
    void shouldReturnAnUpdateTest() {

        CharacterDTO expectedDto = CharacterDTOMother.returnOne();
        expectedDto.setName("Manolo");

        CharacterEntity expectedEntity = CharacterEntityMother.returnOne();
        expectedEntity.setName("Manolo");

        Mockito.when(characterRepository.findById(1)).thenReturn(Optional.of(expectedEntity));
        Mockito.when(mapper.map(expectedDto, CharacterEntity.class)).thenReturn(expectedEntity);
        Mockito.when(characterRepository.save(expectedEntity)).thenReturn(expectedEntity);
        Mockito.when(mapper.map(expectedEntity, CharacterDTO.class)).thenReturn(expectedDto);

        final CharacterDTO result = characterService.edit(expectedDto, 1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedDto, result);
        Mockito.verify(characterRepository).findById(1);
        Mockito.verify(characterRepository).save(expectedEntity);
    }

    @Test
    void shouldDeleteTest() {

        CharacterEntity expectedEntity = CharacterEntityMother.returnOne();

        Mockito.when(characterRepository.findById(1)).thenReturn(Optional.of(expectedEntity));

        characterService.delete(1);

        final CharacterDTO result = characterService.getById(1);

        Assertions.assertNull(result);
        Mockito.verify(characterRepository).findById(1);

    }
}