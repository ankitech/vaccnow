package com.ankitech.vaccnow.service.implementations;

import com.ankitech.vaccnow.model.Allocation;
import com.ankitech.vaccnow.model.MyEntry;
import com.ankitech.vaccnow.repository.AllocationRepository;
import com.ankitech.vaccnow.repository.BranchRepository;
import com.ankitech.vaccnow.service.interfaces.AllocationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.groupingBy;

@Service
public class AllocationServiceImpl implements AllocationService {

    private final AllocationRepository allocationRepository;

    public AllocationServiceImpl(AllocationRepository allocationRepository, BranchRepository branchRepository) {
        this.allocationRepository = allocationRepository;
    }

    @Override
    public Map<Map.Entry<String, String>, List<Allocation>> getAllocationPerBranch() {
        Map<String, List<Allocation>> collect = StreamSupport.stream(allocationRepository.findAll().spliterator(), false).collect(groupingBy(Allocation::getBranchId));
        Map<Map.Entry<String, String>, List<Allocation>> result = new HashMap<>();

        collect.forEach((branchId, allocations) -> result.put(new MyEntry<>("branchId", branchId), allocations));

        return result;
    }

    @Override
    public List<Allocation> getAllocationByBranchId(String branchId) {

        return allocationRepository.findAllByBranchId(branchId);

    }
}
