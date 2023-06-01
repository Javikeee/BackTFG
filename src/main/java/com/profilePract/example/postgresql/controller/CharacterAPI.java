package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.CharacterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RequestMapping("/api/character")
@Tag(name = "Character API", description = "Character API REST with CRUD methods")
public interface CharacterAPI {

    @Operation(summary = "findAll Character", description = "Retrieves all characters from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all characters", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById Character", description = "Retrieve a character from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved a character", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create Character", description = "Create a new character in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new character", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody CharacterDTO characterDTO);

    @Operation(summary = "edit Character", description = "Edit a character in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit a character", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody CharacterDTO characterDTO, @PathVariable Integer id);

    @Operation(summary = "delete Character", description = "Delete a character in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a character", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}