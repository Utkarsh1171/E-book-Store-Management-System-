package com.example.Transaction_Management.repo;

import com.example.Transaction_Management.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
