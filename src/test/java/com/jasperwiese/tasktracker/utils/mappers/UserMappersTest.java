package com.jasperwiese.tasktracker.utils.mappers;

import com.jasperwiese.tasktracker.dto.UserDto;
import com.jasperwiese.tasktracker.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserMappersTest {
    private final UserMappers userMappers = new UserMappers();
    private User user;
    private UserDto userDto;
    private UUID userId;
    @BeforeEach
    void setUp() {
        userId = UUID.fromString("a665bd5b-934b-48a9-8fbe-ac6993a6ca68");
        user = User
                .builder()
                .userId(userId)
                .firstName("James")
                .lastName("Morrisey")
                .email("james.m@gmail.com")
                .mobile("27857446790")
                .password("bongo123")
                .build();

        userDto = UserDto
                .builder()
                .userId(userId)
                .firstName("James")
                .lastName("Morrisey")
                .email("james.m@gmail.com")
                .mobile("27857446790")
                .password("bongo123")
                .build();
    }

    @Test
    void itShouldMapToDto() {
        //Given
        //When
        UserDto userMappedToDto = userMappers.mapToDto(user);
        //Then
        assertThat(userMappedToDto).isEqualTo(userDto);
    }

    @Test
    void itShouldMapToEntity() {
        //Given
        //When
        User userDtoMappedToEntity = userMappers.mapToEntity(userDto);
        //Then
        assertThat(userDtoMappedToEntity).isEqualTo(user);
    }
}