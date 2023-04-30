package com.aledev.springbootrestfulmicroservices.service.impl;

import com.aledev.springbootrestfulmicroservices.DTO.UserDto;
import com.aledev.springbootrestfulmicroservices.entity.User;
import com.aledev.springbootrestfulmicroservices.exception.EmailAlreadyExistsException;
import com.aledev.springbootrestfulmicroservices.exception.ResourceNotFoundException;
import com.aledev.springbootrestfulmicroservices.mapper.AutoUserMapper;
import com.aledev.springbootrestfulmicroservices.mapper.UserMapper;
import com.aledev.springbootrestfulmicroservices.repository.UserRepository;
import com.aledev.springbootrestfulmicroservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw  new EmailAlreadyExistsException("Email already exisrs for user.");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);

    }

    @Override
    public UserDto findById(Long id) {
        User userExist = userRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", id));
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
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", id));
        userExisting.setFirsName(user.getFirsName());
        userExisting.setLastName(user.getLastName());
        userExisting.setEmail(user.getEmail());
        User userUpdate = userRepository.save(userExisting);
        return AutoUserMapper.MAPPER.mapToUserDto(userUpdate);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", userId));
        userRepository.deleteById(userId);
    }
}

