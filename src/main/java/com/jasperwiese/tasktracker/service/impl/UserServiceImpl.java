package com.jasperwiese.tasktracker.service.impl;

import com.jasperwiese.tasktracker.dto.UserDto;
import com.jasperwiese.tasktracker.dto.UserResponse;
import com.jasperwiese.tasktracker.entity.User;
import com.jasperwiese.tasktracker.repository.UserRepository;
import com.jasperwiese.tasktracker.service.UserService;
import com.jasperwiese.tasktracker.utils.mappers.UserMappers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMappers userMappers;

    public UserServiceImpl(UserRepository userRepository, UserMappers userMappers) {
        this.userRepository = userRepository;
        this.userMappers = userMappers;
    }
    //TODO: validation checks to be added for user creation.
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMappers.mapToEntity(userDto);
        return userMappers.mapToDto(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(UUID userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            return userMappers.mapToDto(userOptional.get());
        }
        //TODO: implement GlobalException Handler
        throw new IllegalStateException("User not found");
    }

    @Override
    public UserDto getUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findUserByEmail(email);
        if(userOptional.isPresent()) {
            return userMappers.mapToDto(userOptional.get());
        }
        throw new IllegalStateException("User not found");
    }

    @Override
    public UserResponse getUsers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> users = userRepository.findAll(pageable);
        List<User> listOfUsers = users.getContent();
        List<UserDto> content = listOfUsers
                .stream()
                .map(p -> userMappers.mapToDto(p))
                .toList();
        return UserResponse
                .builder()
                .content(content)
                .pageNo(users.getSize())
                .pageSize(users.getSize())
                .totalElements(users.getTotalElements())
                .totalPages(users.getTotalPages())
                .last(users.isLast())
                .build();
    }
    // TODO: Need to add validation checks for Update services.
    @Override
    public Integer updateUserFirstNameByUserId(String firstName, UUID userId) {
        return userRepository.updateUserFirstNameByUserId(firstName, userId);
    }

    @Override
    public Integer updateUserLastNameByUserId(String lastName, UUID userId) {
        return userRepository.updateUserLastNameByUserId(lastName, userId);
    }

    @Override
    public Integer updateUserEmailByUserId(String email, UUID userId) {
        return userRepository.updateUserEmailByUserId(email, userId);
    }

    @Override
    public Integer updateUserMobileByUserId(String mobile, UUID userId) {
        return userRepository.updateUserMobileByUserId(mobile, userId);
    }
    //TODO: need to implement bcrypt & validation checks for password service.
    @Override
    public Integer updateUserPasswordByUserId(String password, UUID userId) {
        return userRepository.updateUserPasswordByUserId(password, userId);
    }

    @Override
    public Integer deleteUserById(UUID userId) {
        return userRepository.deleteByUserId(userId);
    }
}
