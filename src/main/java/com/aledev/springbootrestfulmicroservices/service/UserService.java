package com.aledev.springbootrestfulmicroservices.service;

import com.aledev.springbootrestfulmicroservices.DTO.UserDto;
import com.aledev.springbootrestfulmicroservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto findById(Long id);

    List<UserDto> findAllUsers();

    UserDto updateUser(Long id, UserDto updateUser);

    void deleteUser(Long id);
}
