package com.example.Software_Change_Request.controller;

import com.example.Software_Change_Request.dto.ChangeRequestDTO; // Make sure to import your ChangeRequestDTO
import com.example.Software_Change_Request.entity.ChangeRequest;
import com.example.Software_Change_Request.service.ChangeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ChangeRequestController {

    @Autowired
    private ChangeRequestService changeRequestService;

    @PostMapping("/create")
    public ResponseEntity<ChangeRequest> createRequest(@RequestBody ChangeRequestDTO changeRequestDto) {
        ChangeRequest changeRequest = changeRequestService.createChangeRequest(changeRequestDto);
        return new ResponseEntity<>(changeRequest, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChangeRequest>> getAllRequests() {
        List<ChangeRequest> requests = changeRequestService.getAllChangeRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<ChangeRequest> approveRequest(@PathVariable Long id) {
        ChangeRequest approvedRequest = changeRequestService.approveChangeRequest(id);
        return new ResponseEntity<>(approvedRequest, HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ChangeRequest> updateStatus(@PathVariable Long id, @RequestBody ChangeRequest.Status status) {
        ChangeRequest updatedRequest = changeRequestService.updateStatus(id, status);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChangeRequest> updateChangeRequest(@PathVariable Long id, @RequestBody ChangeRequest updatedRequest) {
        ChangeRequest changedRequest = changeRequestService.updateChangeRequest(id, updatedRequest);
        return new ResponseEntity<>(changedRequest, HttpStatus.OK);
    }

    // Additional endpoints can be added here as needed
}
