package com.example.Payment_and_Subscription_API.repo;

import com.example.Payment_and_Subscription_API.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
