package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, String> {
}
