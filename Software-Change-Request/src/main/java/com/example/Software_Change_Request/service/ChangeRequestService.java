package com.example.Software_Change_Request.service;

import com.example.Software_Change_Request.dto.ChangeRequestDTO;
import com.example.Software_Change_Request.entity.ChangeRequest;
import com.example.Software_Change_Request.entity.ChangeRequest.Priority;
import com.example.Software_Change_Request.entity.Project;
import com.example.Software_Change_Request.repo.ChangeRequestRepository;
import com.example.Software_Change_Request.repo.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeRequestService {

    @Autowired
    private ChangeRequestRepository changeRequestRepository;

    @Autowired
    private ProjectRepository projectRepository; // Ensure the ProjectRepository is autowired

    @Transactional
    public ChangeRequest createChangeRequest(ChangeRequestDTO changeRequestDto) {
        Project project = projectRepository.findById(changeRequestDto.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Project not found with ID: " + changeRequestDto.getProjectId()));

        ChangeRequest changeRequest = new ChangeRequest();

        // Set properties on changeRequest from changeRequestDto
        changeRequest.setTitle(changeRequestDto.getTitle());
        changeRequest.setDescription(changeRequestDto.getDescription());

        // Convert String to Priority Enum
        try {
            changeRequest.setPriority(Priority.valueOf(changeRequestDto.getPriority().toUpperCase())); // Convert String to Priority
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid priority value: " + changeRequestDto.getPriority());
        }

        changeRequest.setDueDate(changeRequestDto.getDueDate());
        changeRequest.setProject(project); // Ensure the project exists

        return changeRequestRepository.save(changeRequest);
    }

    // Method to get all change requests
    public List<ChangeRequest> getAllChangeRequests() {
        return changeRequestRepository.findAll();
    }

    // Method to approve a change request
    public ChangeRequest approveChangeRequest(Long id) {
        ChangeRequest request = changeRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Change Request not found with ID: " + id));
        request.setStatus(ChangeRequest.Status.APPROVED); // Change status to APPROVED
        return changeRequestRepository.save(request);
    }

    // Method to update the status of a change request
    public ChangeRequest updateStatus(Long id, ChangeRequest.Status status) {
        ChangeRequest request = changeRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Change Request not found with ID: " + id));
        request.setStatus(status); // Update the status
        return changeRequestRepository.save(request);
    }

    // Method to update change request details
    public ChangeRequest updateChangeRequest(Long id, ChangeRequest updatedRequest) {
        ChangeRequest existingRequest = changeRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Change Request not found with ID: " + id));

        // Update the existing request's fields
        existingRequest.setTitle(updatedRequest.getTitle());
        existingRequest.setDescription(updatedRequest.getDescription());
        existingRequest.setPriority(updatedRequest.getPriority());
        existingRequest.setDueDate(updatedRequest.getDueDate());
        // Update other fields as necessary

        return changeRequestRepository.save(existingRequest);
    }
}
