package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Allocation;
import com.ankitech.vaccnow.repository.AllocationRepository;
import com.ankitech.vaccnow.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class AllocationServiceImpl implements AllocationService {

    private final AllocationRepository allocationRepository;
    private final BranchRepository branchRepository;

    public AllocationServiceImpl(AllocationRepository allocationRepository, BranchRepository branchRepository) {
        this.allocationRepository = allocationRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Map<String, List<Allocation>> getAllocationPerBranch() {
        Map<String, List<Allocation>> collect = allocationRepository.findAll().stream().collect(groupingBy(Allocation::getBranchId));
        Map<String, List<Allocation>> result = new HashMap<>();

        collect.forEach((s, allocations) -> result.put(branchRepository.findById(s).get().getName(), allocations));

        return result;
    }
}
