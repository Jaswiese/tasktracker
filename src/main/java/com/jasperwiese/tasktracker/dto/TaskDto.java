package com.jasperwiese.tasktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
