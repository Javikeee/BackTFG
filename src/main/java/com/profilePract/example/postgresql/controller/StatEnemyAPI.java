package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.StatEnemyDTO;
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
@RequestMapping("/api/stat-enemy")
@Tag(name = "StatEnemy API", description = "StatEnemy API REST with CRUD methods")
public interface StatEnemyAPI {

    @Operation(summary = "findAll StatEnemy", description = "Retrieves all statEnemys from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all statEnemys", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatEnemyDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById StatEnemy", description = "Retrieve a statEnemy from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved a statEnemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatEnemyDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create StatEnemy", description = "Create a new statEnemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new statEnemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatEnemyDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody StatEnemyDTO StatEnemyDTO);

    @Operation(summary = "edit StatEnemy", description = "Edit a statEnemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit a statEnemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatEnemyDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody StatEnemyDTO StatEnemyDTO, @PathVariable Integer id);

    @Operation(summary = "delete StatEnemy", description = "Delete a statEnemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a statEnemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatEnemyDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}