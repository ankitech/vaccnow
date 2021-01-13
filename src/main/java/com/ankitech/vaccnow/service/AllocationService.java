package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Allocation;

import java.util.List;
import java.util.Map;

public interface AllocationService {

    Map<String, List<Allocation>> getAllocationPerBranch();

    List<Allocation> getAllocationByBranchId(String branchId);
}
