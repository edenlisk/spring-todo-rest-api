package me.edenlisk.springboottodo.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
public class Todo {

    @Id
    private Integer id;


    @Column(name = "user_id")
    @NotEmpty
    private String userId;
    @NotEmpty
    private String description;

    private String category;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Column(name = "target_date")
    private LocalDateTime targetDate;

    public Todo() {
    }

    public Todo(String userId, String description, String category, Boolean isCompleted, LocalDateTime targetDate) {
        if (!targetDate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Target date cannot be in the past");
        }
        this.userId = userId;
        this.description = description;
        this.category = category;
        this.isCompleted = isCompleted;
        this.targetDate = targetDate;
    }

    // getters and setters

    public Integer id() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String userId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String category() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public LocalDateTime targetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", isCompleted=" + isCompleted +
                ", targetDate=" + targetDate +
                '}';
    }
}