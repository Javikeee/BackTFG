package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.FloorEnemyDTO;
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
@RequestMapping("/api/floor-enemy")
@Tag(name = "FloorEnemy API", description = "FloorEnemy API REST with CRUD methods")
public interface FloorEnemyAPI {

    @Operation(summary = "findAll FloorEnemy", description = "Retrieves all floorEnemies from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all floorEnemies", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorEnemyDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById FloorEnemy", description = "Retrieve a floorEnemy from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved a floorEnemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorEnemyDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create FloorEnemy", description = "Create a new floorEnemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new floorEnemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorEnemyDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody FloorEnemyDTO FloorEnemyDTO);

    @Operation(summary = "edit FloorEnemy", description = "Edit a floorEnemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit a floorEnemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorEnemyDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody FloorEnemyDTO FloorEnemyDTO, @PathVariable Integer id);

    @Operation(summary = "delete FloorEnemy", description = "Delete a floorEnemy in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a floorEnemy", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorEnemyDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}
