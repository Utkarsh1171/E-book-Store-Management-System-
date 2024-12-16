package com.example.Software_Change_Request.dto;

import java.time.LocalDate;

public class ChangeRequestDTO {

    private Long projectId; // Assuming this is also a field in your DTO
    private String title;
    private String description;
    private String priority; // Ensure priority is of the correct type (String, Enum, etc.)
    private LocalDate dueDate; // Assuming dueDate is of type LocalDate

    // Getters and Setters
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() { // Getter for priority
        return priority;
    }

    public void setPriority(String priority) { // Setter for priority
        this.priority = priority;
    }

    public LocalDate getDueDate() { // Getter for dueDate
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) { // Setter for dueDate
        this.dueDate = dueDate;
    }
}
