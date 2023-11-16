package com.jasperwiese.tasktracker.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
//TODO: implement testcontainers
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void itShouldFindUserByEmail() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldUpdateUserFirstNameByUserId() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldUpdateUserLastNameByUserId() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldUpdateUserMobileByUserId() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldUpdateUserEmailByUserId() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldUpdateUserPasswordByUserId() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldDeleteByUserId() {
        //Given
        //When
        //Then
    }
}