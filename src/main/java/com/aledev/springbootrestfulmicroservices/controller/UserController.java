package com.aledev.springbootrestfulmicroservices.controller;

import com.aledev.springbootrestfulmicroservices.DTO.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {
    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user);

    @Operation(
            summary = "Get User by id REST API",
            description = "Get User by ID REST API is used to get single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCESS"
    )
    ResponseEntity<UserDto> findUserById(@PathVariable("id") Long userId);

    @Operation(
            summary = "Get ALL User REST API",
            description = "Get ALL User REST API is used to get all users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCESS"
    )
    ResponseEntity<List<UserDto>> findAll();

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user from the database"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 NOCONTENT"
    )
    ResponseEntity<Void> updateUser(@PathVariable("id") Long userId, @Valid @RequestBody UserDto user);

    @Operation(
            summary = "dELETE User REST API",
            description = "Delete User REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 204 SUCESS"
    )
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id);
}
