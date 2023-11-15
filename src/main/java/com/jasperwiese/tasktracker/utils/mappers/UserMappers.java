package com.jasperwiese.tasktracker.utils.mappers;

import com.jasperwiese.tasktracker.dto.UserDto;
import com.jasperwiese.tasktracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMappers {
    public UserDto mapToDto(User user) {
        return UserDto
                .builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .password(user.getPassword())
                .build();
    }

    public User mapToEntity(UserDto userDto) {
        return User
                .builder()
                .userId(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .mobile(userDto.getMobile())
                .password(userDto.getPassword())
                .build();
    }

}
