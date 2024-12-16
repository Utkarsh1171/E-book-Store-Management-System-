package com.example.Software_Change_Request.repo;

import com.example.Software_Change_Request.entity.ChangeRequest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Long> {

    List<ChangeRequest> findByStatus(String status);
}
