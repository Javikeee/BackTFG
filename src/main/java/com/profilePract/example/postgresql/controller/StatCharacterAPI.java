package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.StatCharacterDTO;
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
@RequestMapping("/api/stat-character")
@Tag(name = "StatCharacter API", description = "StatCharacter API REST with CRUD methods")
public interface StatCharacterAPI {

    @Operation(summary = "findAll StatCharacter", description = "Retrieves all statCharacters from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all statCharacters", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatCharacterDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById StatCharacter", description = "Retrieve a statCharacter from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved a statCharacter", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatCharacterDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create StatCharacter", description = "Create a new statCharacter in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new statCharacter", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatCharacterDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody StatCharacterDTO statCharacterDTO);

    @Operation(summary = "edit StatCharacter", description = "Edit a statCharacter in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit a statCharacter", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatCharacterDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody StatCharacterDTO statCharacterDTO, @PathVariable Integer id);

    @Operation(summary = "delete StatCharacter", description = "Delete a statCharacter in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a statCharacter", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatCharacterDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}