package com.aledev.springbootrestfulmicroservices.mapper;

import com.aledev.springbootrestfulmicroservices.DTO.UserDto;
import com.aledev.springbootrestfulmicroservices.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirsName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirsName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
