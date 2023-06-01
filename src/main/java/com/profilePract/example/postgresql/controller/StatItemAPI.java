package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.StatItemDTO;
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
@RequestMapping("/api/stat-item")
@Tag(name = "StatItem API", description = "StatItem API REST with CRUD methods")
public interface StatItemAPI {

    @Operation(summary = "findAll StatItem", description = "Retrieves all statItems from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all statItems", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatItemDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById StatItem", description = "Retrieve a statItem from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved a statItem", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatItemDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create StatItem", description = "Create a new statItem in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new statItem", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatItemDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody StatItemDTO StatItemDTO);

    @Operation(summary = "edit StatItem", description = "Edit a statItem in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit a statItem", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatItemDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody StatItemDTO StatItemDTO, @PathVariable Integer id);

    @Operation(summary = "delete StatItem", description = "Delete a statItem in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a statItem", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatItemDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}