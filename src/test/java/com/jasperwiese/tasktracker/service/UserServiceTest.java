package com.jasperwiese.tasktracker.service;

import com.jasperwiese.tasktracker.dto.UserDto;
import com.jasperwiese.tasktracker.dto.UserResponse;
import com.jasperwiese.tasktracker.entity.User;
import com.jasperwiese.tasktracker.repository.UserRepository;
import com.jasperwiese.tasktracker.service.impl.UserServiceImpl;
import com.jasperwiese.tasktracker.utils.mappers.UserMappers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMappers userMappers;

    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;
    @Captor
    private ArgumentCaptor<UserDto> userDtoArgumentCaptor;

    private User user;
    private UUID userId;
    private UserDto userDto;

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
    void itShouldCreateUser_AndReturnUserDto() {
        //Given
        given(userMappers.mapToEntity(userDto)).willReturn(user);
        given(userMappers.mapToDto(user)).willReturn(userDto);
        when(userRepository.save(any(User.class))).thenReturn(user);
        //When
        UserDto savedUser = userServiceImpl.createUser(userDto);
        //Then
        then(userRepository).should().save(userArgumentCaptor.capture());
        User userArgumentCaptorValue = userArgumentCaptor.getValue();
        assertThat(userArgumentCaptorValue).isEqualTo(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void itShouldGetUserById_AndReturnUserDto() {
        //Given
        when(userRepository.findById(userId)).thenReturn(Optional.ofNullable(user));
        given(userMappers.mapToDto(user)).willReturn(userDto);
        //When
        UserDto returnedUser = userServiceImpl.getUserById(userId);
        //Then
        verify(userRepository, times(1)).findById(userId);
        assertThat(returnedUser).isNotNull();
    }

    @Test
    void itShouldGetUserByEmail() {
        //Given
        String userEmail = user.getEmail();
        given(userRepository.findUserByEmail(userEmail)).willReturn(Optional.ofNullable(user));
        given(userMappers.mapToDto(user)).willReturn(userDto);
        //When
        UserDto returnedUser = userServiceImpl.getUserByEmail(userEmail);
        //Then
        verify(userRepository, times(1)).findUserByEmail(userEmail);
        assertThat((returnedUser)).isNotNull();
    }

    @Test
    void itShouldGetUsers() {
        //Given
        Page<User> users = mock(Page.class);
        Pageable pageable = PageRequest.of(1, 10);
        given(userRepository.findAll(any(Pageable.class))).willReturn(users);
        //When
        UserResponse userResponse = userServiceImpl.getUsers(1, 10);
        //Then
        verify(userRepository, times(1)).findAll(pageable);
        assertThat(userResponse).isNotNull();
    }

    @Test
    void itShouldUpdateUserFirstNameByUserId() {
        //Given
        String firstName = "bob";
        UUID userId = user.getUserId();
        given(userRepository.updateUserFirstNameByUserId(firstName, userId)).willReturn(1);
        //When
        Integer fieldsUpdated = userRepository.updateUserFirstNameByUserId(firstName, userId);
        //Then
        verify(userRepository, times(1)).updateUserFirstNameByUserId(firstName, userId);
        assertThat(fieldsUpdated).isNotNull();
    }

    @Test
    void itShouldUpdateUserLastNameByUserId() {
        //Given
        String lastName = "ross";
        UUID userId = user.getUserId();
        given(userRepository.updateUserLastNameByUserId(lastName, userId)).willReturn(1);
        //When
        Integer fieldsUpdated = userRepository.updateUserLastNameByUserId(lastName, userId);
        //Then
        verify(userRepository, times(1)).updateUserLastNameByUserId(lastName, userId);
        assertThat(fieldsUpdated).isNotNull();
    }

    @Test
    void itShouldUpdateUserEmailByUserId() {
        //Given
        String email = "bob.r@gmail.com";
        UUID userId = user.getUserId();
        given(userRepository.updateUserEmailByUserId(email, userId)).willReturn(1);
        //When
        Integer fieldsUpdated = userRepository.updateUserEmailByUserId(email, userId);
        //Then
        verify(userRepository, times(1)).updateUserEmailByUserId(email, userId);
        assertThat(fieldsUpdated).isNotNull();
    }

    @Test
    void itShouldUpdateUserMobileByUserId() {
        //Given
        String mobile = "27756677848";
        UUID userId = user.getUserId();
        given(userRepository.updateUserMobileByUserId(mobile, userId)).willReturn(1);
        //When
        Integer fieldsUpdated = userRepository.updateUserMobileByUserId(mobile, userId);
        //Then
        verify(userRepository, times(1)).updateUserMobileByUserId(mobile, userId);
        assertThat(fieldsUpdated).isNotNull();
    }

    @Test
    void itShouldUpdateUserPasswordByUserId() {
        //Given
        String password = "fg123asd#$CD";
        UUID userId = user.getUserId();
        given(userRepository.updateUserPasswordByUserId(password, userId)).willReturn(1);
        //When
        Integer fieldsUpdated = userRepository.updateUserPasswordByUserId(password, userId);
        //Then
        verify(userRepository, times(1)).updateUserPasswordByUserId(password, userId);
        assertThat(fieldsUpdated).isNotNull();
    }

    @Test
    void itShouldDeleteUserById() {
        //Given
        UUID userId = user.getUserId();
        given(userRepository.deleteByUserId(userId)).willReturn(1);
        //When
        Integer rowDeleted = userRepository.deleteByUserId(userId);
        //Then
        verify(userRepository, times(1)).deleteByUserId(userId);
        assertThat(rowDeleted).isNotNull();
    }
}