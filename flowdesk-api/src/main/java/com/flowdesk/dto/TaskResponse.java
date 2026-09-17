package com.flowdesk.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskResponse {
    Long id;
    String title;
    String status;
    String priority;
    String deadline;
    boolean completed;
}