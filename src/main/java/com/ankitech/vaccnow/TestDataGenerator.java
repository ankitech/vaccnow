package com.ankitech.vaccnow;

import com.ankitech.vaccnow.model.Allocation;
import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.model.Location;
import com.ankitech.vaccnow.model.Vaccine;
import com.ankitech.vaccnow.repository.AllocationRepository;
import com.ankitech.vaccnow.repository.BranchRepository;
import com.ankitech.vaccnow.repository.VaccineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestDataGenerator implements CommandLineRunner {

    private final BranchRepository branchRepository;
    private final VaccineRepository vaccineRepository;
    private final AllocationRepository allocationRepository;

    public TestDataGenerator(BranchRepository branchRepository, VaccineRepository vaccineRepository, AllocationRepository allocationRepository) {
        this.branchRepository = branchRepository;
        this.vaccineRepository = vaccineRepository;
        this.allocationRepository = allocationRepository;
    }

    @Override
    public void run(String... args) {

        //clean up the DB
        branchRepository.deleteAll();
        vaccineRepository.deleteAll();
        allocationRepository.deleteAll();

        Branch b1 = Branch.builder().name("pimple saudagar").location(Location.PUNE).build();
        Branch b2 = Branch.builder().name("dadar").location(Location.MUMBAI).build();
        Branch b3 = Branch.builder().name("nehru place").location(Location.DELHI).build();

        branchRepository.saveAll(List.of(b1, b2, b3));

        Vaccine v1 = Vaccine.builder().name("covax").cost(1000).build();
        Vaccine v2 = Vaccine.builder().name("pfizer").cost(2000).build();
        Vaccine v3 = Vaccine.builder().name("bharattec").cost(350).build();

        vaccineRepository.saveAll(List.of(v1, v2, v3));

        Allocation a1 = Allocation.builder().branchId(b1.getId()).vaccineId(v1.getId()).count(200).build();
        Allocation a2 = Allocation.builder().branchId(b2.getId()).vaccineId(v2.getId()).count(500).build();
        Allocation a3 = Allocation.builder().branchId(b3.getId()).vaccineId(v3.getId()).count(700).build();
        Allocation a4 = Allocation.builder().branchId(b1.getId()).vaccineId(v2.getId()).count(400).build();
        Allocation a5 = Allocation.builder().branchId(b2.getId()).vaccineId(v3.getId()).count(350).build();

        allocationRepository.saveAll(List.of(a1, a2, a3, a4, a5));
    }
}
