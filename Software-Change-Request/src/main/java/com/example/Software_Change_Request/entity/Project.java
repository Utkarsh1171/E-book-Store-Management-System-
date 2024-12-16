package com.example.Software_Change_Request.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ChangeRequest> changeRequests;

    // Default constructor
    public Project() {
    }

    // Parameterized constructor
    public Project(Long id, String name, String description, List<ChangeRequest> changeRequests) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.changeRequests = changeRequests;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ChangeRequest> getChangeRequests() {
        return changeRequests;
    }

    public void setChangeRequests(List<ChangeRequest> changeRequests) {
        this.changeRequests = changeRequests;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", changeRequests=" + changeRequests + '}';
    }
}
