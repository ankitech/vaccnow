package com.ankitech.vaccnow;

import com.ankitech.vaccnow.model.Allocation;
import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.model.Location;
import com.ankitech.vaccnow.model.Payment;
import com.ankitech.vaccnow.model.Schedule;
import com.ankitech.vaccnow.model.Slot;
import com.ankitech.vaccnow.model.Vaccine;
import com.ankitech.vaccnow.repository.AllocationRepository;
import com.ankitech.vaccnow.repository.BranchRepository;
import com.ankitech.vaccnow.repository.ScheduleRepository;
import com.ankitech.vaccnow.repository.SlotRepository;
import com.ankitech.vaccnow.repository.VaccineRepository;
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

    public TestDataGenerator(BranchRepository branchRepository, VaccineRepository vaccineRepository, AllocationRepository allocationRepository, SlotRepository slotRepository, ScheduleRepository scheduleRepository) {
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

        Slot s1 = Slot.builder().branchId(b1.getId()).from(LocalDateTime.now().plusHours(1).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s2 = Slot.builder().branchId(b1.getId()).from(LocalDateTime.now().plusHours(2).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s3 = Slot.builder().branchId(b1.getId()).from(LocalDateTime.now().plusHours(3).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s4 = Slot.builder().branchId(b1.getId()).from(LocalDateTime.now().plusHours(4).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();

        Slot s5 = Slot.builder().branchId(b2.getId()).from(LocalDateTime.now().plusHours(1).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s6 = Slot.builder().branchId(b2.getId()).from(LocalDateTime.now().plusHours(2).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s7 = Slot.builder().branchId(b2.getId()).from(LocalDateTime.now().plusHours(3).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s8 = Slot.builder().branchId(b2.getId()).from(LocalDateTime.now().plusHours(4).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s9 = Slot.builder().branchId(b2.getId()).from(LocalDateTime.now().plusHours(5).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();

        Slot s10 = Slot.builder().branchId(b3.getId()).from(LocalDateTime.now().plusHours(1).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s11 = Slot.builder().branchId(b3.getId()).from(LocalDateTime.now().plusHours(2).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s12 = Slot.builder().branchId(b3.getId()).from(LocalDateTime.now().plusHours(3).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s13 = Slot.builder().branchId(b3.getId()).from(LocalDateTime.now().plusHours(4).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
        Slot s14 = Slot.builder().branchId(b3.getId()).from(LocalDateTime.now().plusHours(5).plusMinutes(15)).to(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();

        slotRepository.saveAll(List.of(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14));

        Schedule sh1 = Schedule.builder()
                .email("ankitech@gmail.com")
                .allocationId(a1.getId())
                .slotId(s1.getId())
                .applied(false)
                .paymentType(Payment.CASH)
                .branchId(b1.getId())
                .build();

        Schedule sh2 = Schedule.builder()
                .email("someone@gmail.com")
                .allocationId(a4.getId())
                .slotId(s2.getId())
                .applied(true)
                .appliedOn(LocalDateTime.now().plusHours(2).plusMinutes(23))
                .paymentType(Payment.CASH)
                .branchId(b1.getId())
                .build();

        Schedule sh3 = Schedule.builder()
                .email("smita@gmail.com")
                .allocationId(a2.getId())
                .slotId(s6.getId())
                .applied(true)
                .appliedOn(LocalDateTime.now().plusHours(2).plusMinutes(18))
                .paymentType(Payment.CREDIT)
                .branchId(b2.getId())
                .build();

        Schedule sh4 = Schedule.builder()
                .email("mohan@gmail.com")
                .allocationId(a3.getId())
                .slotId(s11.getId())
                .applied(true)
                .appliedOn(LocalDateTime.now().plusHours(2).plusMinutes(20))
                .paymentType(Payment.CASH)
                .branchId(b3.getId())
                .build();

        scheduleRepository.saveAll(List.of(sh1, sh2, sh3, sh4));
    }
}
