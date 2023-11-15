package com.jasperwiese.tasktracker.controller;

import com.jasperwiese.tasktracker.dto.UserDto;
import com.jasperwiese.tasktracker.dto.UserResponse;
import com.jasperwiese.tasktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user/create")
    public ResponseEntity<UserDto> createUser(
            @RequestBody UserDto userDto
    ){
        System.out.println(userDto);
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("user/unique-by-id/")
    public ResponseEntity<UserDto> getUserById(
            @RequestParam(value = "userId", required = true) UUID userId
    ){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("user/unique-by-email/")
    public ResponseEntity<UserDto> getUserByEmail(
            @RequestParam(value = "email", required = true) String email
    ){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("user/all")
    public ResponseEntity<UserResponse> getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize
    ){
        return new ResponseEntity<>(userService.getUsers(pageNo,pageSize), HttpStatus.OK);
    }

    @PutMapping("user/update/first-name/")
    public ResponseEntity<Integer> updateUserFirstNameByUserId(
            @RequestParam(value = "firstName", required = true) String firstName,
            @RequestParam(value = "userId", required = true) UUID userId
    ) {
        return new ResponseEntity<>(userService.updateUserFirstNameByUserId(firstName, userId), HttpStatus.OK);
    }

    @PutMapping("user/update/last-name/")
    public ResponseEntity<Integer> updateUserLastNameByUserId(
            @RequestParam(value = "lastName", required = true) String lastName,
            @RequestParam(value = "userId", required = true) UUID userId
    ){
        return new ResponseEntity<>(userService.updateUserLastNameByUserId(lastName, userId), HttpStatus.OK);
    }

    @PutMapping("user/update/email/")
    public ResponseEntity<Integer> updateUserEmailByUserId(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "userId", required = true) UUID userId
    ) {
        return new ResponseEntity<>(userService.updateUserEmailByUserId(email, userId), HttpStatus.OK);
    }

    @PutMapping("user/update/mobile/")
    public ResponseEntity<Integer> updateUserMobileByUserId(
            @RequestParam(value = "mobile", required = true) String mobile,
            @RequestParam(value = "userId", required = true) UUID userId
    ) {
        return new ResponseEntity<>(userService.updateUserMobileByUserId(mobile, userId), HttpStatus.OK);
    }

    @PutMapping("user/update/password/")
    public ResponseEntity<Integer> updateUserPasswordByUserId(
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "userId", required = true) UUID userId
    ) {
        return new ResponseEntity<>(userService.updateUserPasswordByUserId(password, userId), HttpStatus.OK);
    }
    @DeleteMapping("user/delete/")
    public ResponseEntity<Integer> deleteUserById(
            @RequestParam(value = "userId", required = true) UUID userId
    ) {
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }






}
