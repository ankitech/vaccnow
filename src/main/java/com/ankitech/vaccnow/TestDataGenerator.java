package com.ankitech.vaccnow;

import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.model.Location;
import com.ankitech.vaccnow.repository.BranchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataGenerator implements CommandLineRunner {

    private final BranchRepository branchRepository;

    public TestDataGenerator(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public void run(String... args) {
        branchRepository.deleteAll();

        branchRepository.save(Branch.builder().name("pimple saudagar").location(Location.PUNE).build());
        branchRepository.save(Branch.builder().name("dadar").location(Location.MUMBAI).build());
        branchRepository.save(Branch.builder().name("nehru place").location(Location.DELHI).build());
    }
}
