package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Allocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository extends CrudRepository<Allocation, String> {

    List<Allocation> findAllByBranchId(String branchId);
}
