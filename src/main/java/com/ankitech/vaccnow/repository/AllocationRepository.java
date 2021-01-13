package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Allocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository extends MongoRepository<Allocation, String> {

    List<Allocation> findAllByBranchId(String branchId);
}
