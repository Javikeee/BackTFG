package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.FloorDTO;
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
@RequestMapping("/api/floor")
@Tag(name = "Floor API", description = "Floor API REST with CRUD methods")
public interface FloorAPI {

    @Operation(summary = "findAll Floor", description = "Retrieves all floors from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all floors", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById Floor", description = "Retrieve a floor from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved a floor", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create Floor", description = "Create a new floor in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new floor", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody FloorDTO floorDTO);

    @Operation(summary = "edit Floor", description = "Edit a floor in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit a floor", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody FloorDTO floorDTO, @PathVariable Integer id);

    @Operation(summary = "delete Floor", description = "Delete a floor in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a floor", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);

}