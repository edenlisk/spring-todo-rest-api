package me.edenlisk.springboottodo.todo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Todo {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    @NotEmpty
    private String userId;
    @NotEmpty
    @Size(min=5, max = 140, message = "Description should be between 5 and 140 characters")
    private String description;

    private String category;

    private Boolean completed;

    private LocalDateTime targetDate;


    public Todo(ObjectId id, String userId, String description, String category, Boolean completed, LocalDateTime targetDate) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.category = category;
        this.completed = completed;
        this.targetDate = targetDate;
    }

    // getters and setters

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getTargetDate() {
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
                ", isCompleted=" + completed +
                ", targetDate=" + targetDate +
                '}';
    }

}