package com.aledev.springbootrestfulmicroservices.controller.impl;

import com.aledev.springbootrestfulmicroservices.DTO.UserDto;
import com.aledev.springbootrestfulmicroservices.controller.UserController;
import com.aledev.springbootrestfulmicroservices.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto userSaved = userService.createUser(user);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.findById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> alUser = userService.findAllUsers();
        return new ResponseEntity<>(alUser, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long userId, @Valid @RequestBody UserDto user) {
        userService.updateUser(userId, user);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
