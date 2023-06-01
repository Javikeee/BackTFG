package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.StatDTO;
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
@RequestMapping("/api/stat")
@Tag(name = "Stat API", description = "Stat API REST with CRUD methods")
public interface StatAPI {

    @Operation(summary = "findAll Stat", description = "Retrieves all stats from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all stats", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById Stat", description = "Retrieve a stat from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved a stat", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create Stat", description = "Create a new stat in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new stat", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody StatDTO statDTO);

    @Operation(summary = "edit Stat", description = "Edit a stat in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit a stat", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody StatDTO statDTO, @PathVariable Integer id);

    @Operation(summary = "delete Stat", description = "Delete a stat in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a stat", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}