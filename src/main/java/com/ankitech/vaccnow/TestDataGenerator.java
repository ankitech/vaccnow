package com.ankitech.vaccnow;

import com.ankitech.vaccnow.model.*;
import com.ankitech.vaccnow.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TestDataGenerator implements CommandLineRunner {

    private final BranchRepository branchRepository;
    private final VaccineRepository vaccineRepository;
    private final AllocationRepository allocationRepository;
    private final SlotRepository slotRepository;
    private final ScheduleRepository scheduleRepository;

    public TestDataGenerator(BranchRepository branchRepository,
                             VaccineRepository vaccineRepository,
                             AllocationRepository allocationRepository,
                             SlotRepository slotRepository,
                             ScheduleRepository scheduleRepository
    ) {
        this.branchRepository = branchRepository;
        this.vaccineRepository = vaccineRepository;
        this.allocationRepository = allocationRepository;
        this.slotRepository = slotRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void run(String... args) {

        //clean up the DB
        branchRepository.deleteAll();
        vaccineRepository.deleteAll();
        allocationRepository.deleteAll();
        slotRepository.deleteAll();
        scheduleRepository.deleteAll();

        Branch b1 = Branch.builder().name("pimple saudagar").location(Location.PUNE.toString()).build();
        Branch b2 = Branch.builder().name("dadar").location(Location.MUMBAI.toString()).build();
        Branch b3 = Branch.builder().name("nehru place").location(Location.DELHI.toString()).build();

        branchRepository.saveAll(List.of(b1, b2, b3));

        Vaccine v1 = Vaccine.builder().name("covax").cost(1000).build();
        Vaccine v2 = Vaccine.builder().name("pfizer").cost(2000).build();
        Vaccine v3 = Vaccine.builder().name("bharattec").cost(350).build();

        vaccineRepository.saveAll(List.of(v1, v2, v3));

        Allocation a1 = Allocation.builder().branch(b1).vaccine(v1).count(200).build();
        Allocation a2 = Allocation.builder().branch(b2).vaccine(v2).count(500).build();
        Allocation a3 = Allocation.builder().branch(b3).vaccine(v3).count(700).build();
        Allocation a4 = Allocation.builder().branch(b1).vaccine(v2).count(400).build();
        Allocation a5 = Allocation.builder().branch(b2).vaccine(v3).count(350).build();

        allocationRepository.saveAll(List.of(a1, a2, a3, a4, a5));

        Slot s1 = Slot.builder().branch(b1).start(LocalDateTime.now().plusHours(1).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s2 = Slot.builder().branch(b1).start(LocalDateTime.now().plusHours(2).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s3 = Slot.builder().branch(b1).start(LocalDateTime.now().minusHours(3).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s4 = Slot.builder().branch(b1).start(LocalDateTime.now().minusHours(10).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();

        Slot s5 = Slot.builder().branch(b2).start(LocalDateTime.now().plusHours(1).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s6 = Slot.builder().branch(b2).start(LocalDateTime.now().plusHours(2).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s7 = Slot.builder().branch(b2).start(LocalDateTime.now().minusHours(10).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s8 = Slot.builder().branch(b2).start(LocalDateTime.now().minusHours(15).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s9 = Slot.builder().branch(b2).start(LocalDateTime.now().minusHours(20).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();

        Slot s10 = Slot.builder().branch(b3).start(LocalDateTime.now().plusHours(1).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s11 = Slot.builder().branch(b3).start(LocalDateTime.now().plusHours(2).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s12 = Slot.builder().branch(b3).start(LocalDateTime.now().minusHours(11).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s13 = Slot.builder().branch(b3).start(LocalDateTime.now().minusHours(12).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s14 = Slot.builder().branch(b3).start(LocalDateTime.now().minusHours(13).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();

        slotRepository.saveAll(List.of(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14));

        Schedule sh1 = Schedule.builder()
                .email("ankitech@gmail.com")
                .allocation(a1)
                .slot(s1)
                .applied(false)
                .paymentType(Payment.CASH.toString())
                .branch(b1)
                .build();

        Schedule sh2 = Schedule.builder()
                .email("someone@gmail.com")
                .allocation(a4)
                .slot(s2)
                .applied(false)
                .paymentType(Payment.CASH.toString())
                .branch(b1)
                .build();

        Schedule sh3 = Schedule.builder()
                .email("other@gmail.com")
                .allocation(a4)
                .slot(s3)
                .applied(true)
                .appliedOn(LocalDateTime.now().minusHours(3).plusMinutes(23))
                .paymentType(Payment.CASH.toString())
                .branch(b1)
                .build();

        Schedule sh4 = Schedule.builder()
                .email("smita@gmail.com")
                .allocation(a2)
                .slot(s6)
                .applied(false)
                .paymentType(Payment.CREDIT.toString())
                .branch(b2)
                .build();

        Schedule sh5 = Schedule.builder()
                .email("murmu@gmail.com")
                .allocation(a2)
                .slot(s7)
                .applied(true)
                .appliedOn(LocalDateTime.now().minusHours(10).plusMinutes(18))
                .paymentType(Payment.CREDIT.toString())
                .branch(b2)
                .build();

        Schedule sh6 = Schedule.builder()
                .email("mohan@gmail.com")
                .allocation(a3)
                .slot(s11)
                .applied(false)
                .paymentType(Payment.CASH.toString())
                .branch(b3)
                .build();

        Schedule sh7 = Schedule.builder()
                .email("gourav@gmail.com")
                .allocation(a3)
                .slot(s13)
                .applied(true)
                .appliedOn(LocalDateTime.now().minusHours(12).plusMinutes(20))
                .paymentType(Payment.CASH.toString())
                .branch(b3)
                .build();

        scheduleRepository.saveAll(List.of(sh1, sh2, sh3, sh4, sh5, sh6, sh7));
    }
}
