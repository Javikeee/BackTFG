package com.profilePract.example.postgresql.controller;

import com.profilePract.example.postgresql.controller.dto.ItemDTO;
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
@RequestMapping("/api/item")
@Tag(name = "Item API", description = "Item API REST with CRUD methods")
public interface ItemAPI {

    @Operation(summary = "findAll Item", description = "Retrieves all items from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all items", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ItemDTO.class)))})
    })
    @GetMapping("")
    ResponseEntity<?> findAll();

    @Operation(summary = "getById Item", description = "Retrieve an item from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved an item", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ItemDTO.class)))})
    })
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Integer id);

    @Operation(summary = "create Item", description = "Create a new item in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new item", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ItemDTO.class)))})
    })
    @PostMapping("")
    ResponseEntity<?> create (@Valid @RequestBody ItemDTO itemDTO);

    @Operation(summary = "edit Item", description = "Edit an item in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit an item", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ItemDTO.class)))})
    })
    @PutMapping("/{id}")
    ResponseEntity<?> edit (@RequestBody ItemDTO itemDTO, @PathVariable Integer id);

    @Operation(summary = "delete Item", description = "Delete a Item in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a Item", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ItemDTO.class)))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);

}
