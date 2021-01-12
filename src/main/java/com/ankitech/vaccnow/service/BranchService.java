package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Branch;

import java.util.List;

public interface BranchService {

    List<Branch> findAllBranches();

    Branch findBranchesById(String branchId) throws GeneralException;
}
