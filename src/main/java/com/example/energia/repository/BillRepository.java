package com.example.energia.repository;

import com.example.energia.entity.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BillRepository extends MongoRepository<Bill, String> {
    List<Bill> findByUserId(String userId);
}
