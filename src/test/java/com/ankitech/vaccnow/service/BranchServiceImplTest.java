package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.model.Location;
import com.ankitech.vaccnow.repository.BranchRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BranchServiceImplTest {

    private final String BRANCH1 = "BRANCHIDISTHISFOR1";
    private final String BRANCH2 = "BRANCHIDISTHISFOR2";
    private final Branch b1 = Branch.builder().id(BRANCH1).name("pimple saudagar").location(Location.PUNE).build();
    private final Branch b2 = Branch.builder().id(BRANCH2).name("dadar").location(Location.MUMBAI).build();
    @Mock
    private BranchRepository branchRepository;
    @InjectMocks
    private BranchServiceImpl branchService;

    @Test
    void findAllBranches() {
        when(branchRepository.findAll()).thenReturn(List.of(b1, b2));
        List<Branch> allBranches = branchService.findAllBranches();

        verify(branchRepository, times(1)).findAll();
        assertEquals(2, allBranches.size());
    }

    @Test
    void findBranchesById() throws GeneralException {
        when(branchRepository.findById(BRANCH1)).thenReturn(Optional.of(b1));
        Branch branchesById = branchService.findBranchesById(BRANCH1);

        verify(branchRepository, times(1)).findById(BRANCH1);
        assertEquals(b1, branchesById);
    }

    @Test
    void branchNotFound() {
        when(branchRepository.findById(BRANCH1)).thenReturn(Optional.empty());

        Assertions.assertThrows(GeneralException.class, () -> branchService.findBranchesById(BRANCH1));

    }
}