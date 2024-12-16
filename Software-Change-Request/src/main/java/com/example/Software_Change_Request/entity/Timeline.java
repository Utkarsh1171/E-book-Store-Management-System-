package com.example.Software_Change_Request.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "timelines")
public class Timeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "change_request_id")
    private ChangeRequest changeRequest;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "completion_date")
    private LocalDate completionDate;

    @Column(length = 500)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChangeRequest getChangeRequest() {
        return changeRequest;
    }

    public void setChangeRequest(ChangeRequest changeRequest) {
        this.changeRequest = changeRequest;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    // Enum for different stages in the timeline
    public enum Status {
        REQUEST_RAISED, APPROVED, REJECTED, IN_DEVELOPMENT, IN_REVIEW, COMPLETED
    }

    // Constructors, toString, equals, and hashCode methods
}
