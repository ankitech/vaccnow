package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Allocation;
import com.ankitech.vaccnow.model.MyEntry;
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

    public AllocationServiceImpl(AllocationRepository allocationRepository, BranchRepository branchRepository) {
        this.allocationRepository = allocationRepository;
    }

    @Override
    public Map<Map.Entry<String, String>, List<Allocation>> getAllocationPerBranch() {
        Map<String, List<Allocation>> collect = allocationRepository.findAll().stream().collect(groupingBy(Allocation::getBranchId));
        Map<Map.Entry<String, String>, List<Allocation>> result = new HashMap<>();

        collect.forEach((branchId, allocations) -> result.put(new MyEntry<>("branchId", branchId), allocations));

        return result;
    }

    @Override
    public List<Allocation> getAllocationByBranchId(String branchId) {

        return allocationRepository.findAllByBranchId(branchId);

    }
}
