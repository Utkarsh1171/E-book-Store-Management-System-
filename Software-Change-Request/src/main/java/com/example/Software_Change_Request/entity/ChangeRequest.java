package com.example.Software_Change_Request.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference; // Import the annotation
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "change_requests")
public class ChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference // This is the back reference
    private Project project;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester;

    @ManyToMany
    @JoinTable(
            name = "change_request_developers",
            joinColumns = @JoinColumn(name = "change_request_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    private List<User> assignedDevelopers;

    @OneToMany(mappedBy = "changeRequest", cascade = CascadeType.ALL)
    private List<Timeline> timelines;

    public String getProjectId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Enum for Priority levels
    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    // Enum for Status of the change request
    public enum Status {
        PENDING, APPROVED, IN_DEVELOPMENT, IN_REVIEW, COMPLETED
    }

    // Default Constructor
    public ChangeRequest() {
        this.status = Status.PENDING;  // Set default status
    }

    // Parameterized Constructor
    public ChangeRequest(Long id, String title, String description, Priority priority, LocalDate dueDate, Project project, User requester, List<User> assignedDevelopers, List<Timeline> timelines) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.project = project;
        this.requester = requester;
        this.assignedDevelopers = assignedDevelopers;
        this.timelines = timelines;
        this.status = Status.PENDING;  // Default to PENDING if not set
    }

    // PrePersist Lifecycle Callback to set default status
    @PrePersist
    protected void onCreate() {
        if (this.status == null) {
            this.status = Status.PENDING;
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public List<User> getAssignedDevelopers() {
        return assignedDevelopers;
    }

    public void setAssignedDevelopers(List<User> assignedDevelopers) {
        this.assignedDevelopers = assignedDevelopers;
    }

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }

    // toString Method (excluding large fields to prevent performance issues)
    @Override
    public String toString() {
        return "ChangeRequest{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + ", priority=" + priority
                + ", dueDate=" + dueDate
                + ", project=" + project
                + ", status=" + status
                + ", requester=" + requester
                + '}';
    }

    // hashCode and equals methods
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, priority, dueDate, project, status, requester);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChangeRequest that = (ChangeRequest) obj;
        return Objects.equals(id, that.id)
                && Objects.equals(title, that.title)
                && Objects.equals(description, that.description)
                && priority == that.priority
                && Objects.equals(dueDate, that.dueDate)
                && Objects.equals(project, that.project)
                && status == that.status
                && Objects.equals(requester, that.requester);
    }
}
