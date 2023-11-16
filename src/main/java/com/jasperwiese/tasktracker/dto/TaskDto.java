package com.jasperwiese.tasktracker.dto;

import lombok.*;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TaskDto {
    private Long taskId;
    private String title;
    private String description;
    private boolean started;
    private boolean completed;
    private ZonedDateTime startDate;
    private ZonedDateTime completedDate;
    private UserDto user;
}
