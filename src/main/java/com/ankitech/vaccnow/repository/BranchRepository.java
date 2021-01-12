package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends MongoRepository<Branch, String> {

    @Override
    List<Branch> findAll();
}
