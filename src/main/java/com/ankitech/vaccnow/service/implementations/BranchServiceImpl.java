package com.ankitech.vaccnow.service.implementations;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.repository.BranchRepository;
import com.ankitech.vaccnow.service.interfaces.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }


    @Override
    public List<Branch> findAllBranches() {
        List<Branch> result = new ArrayList<>();
        branchRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Branch findBranchesById(String branchId) throws GeneralException {
        return branchRepository.findById(branchId).orElseThrow(() -> new GeneralException(HttpStatus.NOT_FOUND, "branch id " + branchId + " not found"));
    }
}
