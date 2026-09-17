package com.flowdesk.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Builder.Default
    @Column(nullable = false)
    String status = "Todo";

    @Builder.Default
    @Column(nullable = false)
    String priority = "Medium";

    @Column(nullable = false)
    String deadline;

    @Builder.Default
    @Column(nullable = false)
    boolean completed = false;
}