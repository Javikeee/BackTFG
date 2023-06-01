package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.FloorItemDTO;
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
@RequestMapping("/api/floor-Item")
@Tag(name = "FloorItem API", description = "FloorItem API REST with CRUD methods")
public interface FloorItemAPI {

    @Operation(summary = "findAll FloorItem", description = "Retrieves all floorEnemies from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all floorEnemies", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorItemDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById FloorItem", description = "Retrieve a floorItem from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved a floorItem", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorItemDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create FloorItem", description = "Create a new floorItem in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new floorItem", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorItemDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody FloorItemDTO FloorItemDTO);

    @Operation(summary = "edit FloorItem", description = "Edit a floorItem in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit a floorItem", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorItemDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody FloorItemDTO FloorItemDTO, @PathVariable Integer id);

    @Operation(summary = "delete FloorItem", description = "Delete a floorItem in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a floorItem", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FloorItemDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);
}
