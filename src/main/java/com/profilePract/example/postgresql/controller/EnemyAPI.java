package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.EnemyDTO;
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
@RequestMapping("/api/enemy")
@Tag(name = "Enemy API", description = "Enemy API REST with CRUD methods")
public interface EnemyAPI {

    @Operation(summary = "findAll Enemy", description = "Retrieves all enemies from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all enemies", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EnemyDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById Enemy", description = "Retrieve an enemy from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved an enemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EnemyDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create Enemy", description = "Create a new enemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new enemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EnemyDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody EnemyDTO enemyDTO);

    @Operation(summary = "edit Enemy", description = "Edit an enemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit an enemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EnemyDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody EnemyDTO enemyDTO, @PathVariable Integer id);

    @Operation(summary = "delete Enemy", description = "Delete an enemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete an enemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EnemyDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}