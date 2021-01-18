package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Allocation;
import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.model.Vaccine;
import com.ankitech.vaccnow.repository.AllocationRepository;
import com.ankitech.vaccnow.service.implementations.AllocationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AllocationServiceImplTest {

    private final String BRANCH1 = "BRANCHIDISTHISFOR1";
    private final String BRANCH2 = "BRANCHIDISTHISFOR2";
    private final String VACCINE1 = "VACCINEIDISTHISFOR1";
    private final String VACCINE2 = "VACCINEIDISTHISFOR2";
    private final Allocation a1 = Allocation.builder().id("ALLOCATIONIDISTHISFOR1").branch(Branch.builder().id(BRANCH1).build()).vaccine(Vaccine.builder().id(VACCINE1).build()).count(200).build();
    private final Allocation a2 = Allocation.builder().id("ALLOCATIONIDISTHISFOR2").branch(Branch.builder().id(BRANCH1).build()).vaccine(Vaccine.builder().id(VACCINE2).build()).count(500).build();
    private final Allocation a3 = Allocation.builder().id("ALLOCATIONIDISTHISFOR3").branch(Branch.builder().id(BRANCH2).build()).vaccine(Vaccine.builder().id(VACCINE1).build()).count(200).build();
    private final Allocation a4 = Allocation.builder().id("ALLOCATIONIDISTHISFOR4").branch(Branch.builder().id(BRANCH2).build()).vaccine(Vaccine.builder().id(VACCINE2).build()).count(500).build();
    @Mock
    private AllocationRepository allocationRepository;
    @InjectMocks
    private AllocationServiceImpl allocationService;

    @Test
    void getAllocationPerBranch() {
        when(allocationRepository.findAll()).thenReturn(List.of(a1, a2, a3, a4));
        Map<Map.Entry<String, String>, List<Allocation>> allocationPerBranch = allocationService.getAllocationPerBranch();

        verify(allocationRepository, times(1)).findAll();
        assertEquals(2, allocationPerBranch.size());
    }

    @Test
    void getAllocationByBranchId() {
        when(allocationRepository.findAllByBranchId(BRANCH1)).thenReturn(List.of(a1, a2));
        List<Allocation> allocationByBranchId = allocationService.getAllocationByBranchId(BRANCH1);

        verify(allocationRepository, times(1)).findAllByBranchId(BRANCH1);
        assertEquals(2, allocationByBranchId.size());
    }
}