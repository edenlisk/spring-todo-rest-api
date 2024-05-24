package me.edenlisk.springboottodo.todo;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Todo(
        Integer id,
        @NotEmpty
        String userId,
        @NotEmpty
        String description,
        String category,
        Boolean isCompleted,
        LocalDateTime targetDate
) {
    public Todo {
        if (!targetDate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Target date cannot be in the past");
        }
    }
}
