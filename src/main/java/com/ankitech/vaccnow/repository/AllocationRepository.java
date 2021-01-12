package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Allocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends MongoRepository<Allocation, String> {
}
