package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.repository.BranchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }


    @Override
    public List<Branch> findAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch findBranchesById(String branchId) throws GeneralException {
        return branchRepository.findById(branchId).orElseThrow(() -> new GeneralException(HttpStatus.NOT_FOUND, "branch id " + branchId + " not found"));
    }
}
