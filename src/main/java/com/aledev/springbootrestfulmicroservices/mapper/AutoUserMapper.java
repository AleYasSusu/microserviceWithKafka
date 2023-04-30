package com.aledev.springbootrestfulmicroservices.mapper;

import com.aledev.springbootrestfulmicroservices.DTO.UserDto;
import com.aledev.springbootrestfulmicroservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
