package com.jasperwiese.tasktracker.service;

import com.jasperwiese.tasktracker.dto.UserDto;
import com.jasperwiese.tasktracker.dto.UserResponse;
import com.jasperwiese.tasktracker.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(UUID userId);
    UserDto getUserByEmail(String email);
    UserResponse getUsers(int pageNo, int pageSize);
    Integer updateUserFirstNameByUserId(String firstName, UUID userId);
    Integer updateUserLastNameByUserId(String lastName, UUID userId);
    Integer updateUserEmailByUserId(String email, UUID userId);
    Integer updateUserMobileByUserId(String mobile, UUID userId);
    Integer updateUserPasswordByUserId(String password, UUID userId);
    Integer deleteUserById(UUID userId);

}
