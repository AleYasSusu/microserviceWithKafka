package com.aledev.springbootrestfulmicroservices.service.impl;

import com.aledev.springbootrestfulmicroservices.DTO.UserDto;
import com.aledev.springbootrestfulmicroservices.entity.User;
import com.aledev.springbootrestfulmicroservices.exception.UserNotFoundException;
import com.aledev.springbootrestfulmicroservices.mapper.AutoUserMapper;
import com.aledev.springbootrestfulmicroservices.mapper.UserMapper;
import com.aledev.springbootrestfulmicroservices.repository.UserRepository;
import com.aledev.springbootrestfulmicroservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);

    }

    @Override
    public UserDto findById(Long id) {
        User userExist = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with id %d not found", id)));
        return AutoUserMapper.MAPPER.mapToUserDto(userExist);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> allUser = userRepository.findAll();
        return allUser.stream()
                .map(AutoUserMapper.MAPPER::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        User userExisting = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        userExisting.setFirsName(user.getFirsName());
        userExisting.setLastName(user.getLastName());
        userExisting.setEmail(user.getEmail());
        User userUpdate = userRepository.save(userExisting);
        return AutoUserMapper.MAPPER.mapToUserDto(userUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
