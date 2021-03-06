package com.ankitech.vaccnow.service.interfaces;

import com.ankitech.vaccnow.model.Allocation;

import java.util.List;
import java.util.Map;

public interface AllocationService {

    Map<Map.Entry<String, String>, List<Allocation>> getAllocationPerBranch();

    List<Allocation> getAllocationByBranchId(String branchId);
}
