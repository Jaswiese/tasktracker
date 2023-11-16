package com.jasperwiese.tasktracker.dto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String password;
}
