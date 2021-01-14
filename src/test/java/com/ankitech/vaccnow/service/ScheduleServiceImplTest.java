package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Payment;
import com.ankitech.vaccnow.model.Schedule;
import com.ankitech.vaccnow.repository.ScheduleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScheduleServiceImplTest {

    private final String BRANCH1 = "BRANCHIDISTHISFOR1";
    private final String BRANCH2 = "BRANCHIDISTHISFOR2";
    private final String BRANCH3 = "BRANCHIDISTHISFOR3";
    private final String ALLOCATION1 = "ALLOCATIONIDISTHISFOR1";
    private final String ALLOCATION2 = "ALLOCATIONIDISTHISFOR2";
    private final String ALLOCATION3 = "ALLOCATIONIDISTHISFOR3";
    private final String SLOT1 = "SLOTIDISTHISFOR1";
    private final String SLOT2 = "SLOTIDISTHISFOR2";
    private final String SLOT3 = "SLOTIDISTHISFOR3";
    private final String SLOT4 = "SLOTIDISTHISFOR4";
    private final String SLOT5 = "SLOTIDISTHISFOR5";
    private final String SLOT6 = "SLOTIDISTHISFOR6";
    private final String SLOT7 = "SLOTIDISTHISFOR7";
    private final String SCHEDULE1 = "SCHEDULEIDISTHISFOR1";
    private final String SCHEDULE2 = "SCHEDULEIDISTHISFOR2";
    private final String SCHEDULE3 = "SCHEDULEIDISTHISFOR3";
    private final String SCHEDULE4 = "SCHEDULEIDISTHISFOR4";
    private final String SCHEDULE5 = "SCHEDULEIDISTHISFOR5";
    private final String SCHEDULE6 = "SCHEDULEIDISTHISFOR6";
    private final String SCHEDULE7 = "SCHEDULEIDISTHISFOR7";
    Schedule sh1 = Schedule.builder()
            .id(SCHEDULE1)
            .email("ankitech@gmail.com")
            .allocationId(ALLOCATION1)
            .slotId(SLOT1)
            .applied(false)
            .paymentType(Payment.CASH)
            .branchId(BRANCH1)
            .build();
    Schedule sh2 = Schedule.builder()
            .id(SCHEDULE2)
            .email("someone@gmail.com")
            .allocationId(ALLOCATION3)
            .slotId(SLOT2)
            .applied(false)
            .paymentType(Payment.CASH)
            .branchId(BRANCH1)
            .build();
    Schedule sh3 = Schedule.builder()
            .id(SCHEDULE3)
            .email("other@gmail.com")
            .allocationId(ALLOCATION3)
            .slotId(SLOT3)
            .applied(true)
            .appliedOn(LocalDateTime.now().minusHours(3).plusMinutes(23))
            .paymentType(Payment.CASH)
            .branchId(BRANCH1)
            .build();
    Schedule sh4 = Schedule.builder()
            .id(SCHEDULE4)
            .email("smita@gmail.com")
            .allocationId(ALLOCATION2)
            .slotId(SLOT4)
            .applied(false)
            .paymentType(Payment.CREDIT)
            .branchId(BRANCH2)
            .build();
    Schedule sh5 = Schedule.builder()
            .id(SCHEDULE5)
            .email("murmu@gmail.com")
            .allocationId(ALLOCATION2)
            .slotId(SLOT5)
            .applied(true)
            .appliedOn(LocalDateTime.now().minusHours(10).plusMinutes(18))
            .paymentType(Payment.CREDIT)
            .branchId(BRANCH2)
            .build();
    Schedule sh6 = Schedule.builder()
            .id(SCHEDULE6)
            .email("mohan@gmail.com")
            .allocationId(ALLOCATION3)
            .slotId(SLOT6)
            .applied(false)
            .paymentType(Payment.CASH)
            .branchId(BRANCH3)
            .build();
    Schedule sh7 = Schedule.builder()
            .id(SCHEDULE7)
            .email("gourav@gmail.com")
            .allocationId(ALLOCATION3)
            .slotId(SLOT7)
            .applied(true)
            .appliedOn(LocalDateTime.now().minusHours(12).plusMinutes(20))
            .paymentType(Payment.CASH)
            .branchId(BRANCH3)
            .build();
    @Mock
    private ScheduleRepository scheduleRepository;
    @InjectMocks
    private ScheduleServiceImpl scheduleService;

    @Test
    void save() {
        when(scheduleRepository.save(any())).thenReturn(sh1);
        assertEquals(sh1, scheduleService.save(sh1));
    }

    @Test
    void findAll() {
        when(scheduleRepository.findAll()).thenReturn(List.of(sh1, sh2, sh3, sh4, sh5, sh6, sh7));
        List<Schedule> scheduleList = scheduleService.findAll();

        verify(scheduleRepository, times(1)).findAll();
        assertEquals(7, scheduleList.size());
    }

    @Test
    void findById() throws GeneralException {

        when(scheduleRepository.findById(anyString())).thenReturn(Optional.of(sh1));
        Schedule serviceById = scheduleService.findById("myid");

        verify(scheduleRepository, times(1)).findById(anyString());
        assertEquals(sh1, serviceById);
    }

    @Test
    void scheduleNotFind() {
        when(scheduleRepository.findById(anyString())).thenReturn(Optional.empty());
        Assertions.assertThrows(GeneralException.class, () -> scheduleService.findById("myid"));
    }

    @Test
    void applyVaccine() throws GeneralException {
        when(scheduleRepository.findById(anyString())).thenReturn(Optional.of(sh1));
        when(scheduleRepository.save(any())).thenReturn(sh1);

        scheduleService.applyVaccine(SCHEDULE1);

        verify(scheduleRepository, times(1)).findById(anyString());
        verify(scheduleRepository, times(1)).save(any());

    }

    @Test
    void getAppliedPerBranch() {
        when(scheduleRepository.findByAppliedIs(true)).thenReturn(List.of(sh3, sh5, sh7));
        Map<Map.Entry<String, String>, List<Schedule>> appliedPerBranch = scheduleService.getAppliedPerBranch();

        verify(scheduleRepository, times(1)).findByAppliedIs(true);
        assertEquals(3, appliedPerBranch.size());
    }

    @Test
    void getAppliedByBranch() {
        when(scheduleRepository.findByAppliedIsAndBranchId(true, BRANCH1)).thenReturn(List.of(sh1, sh2, sh3));
        List<Schedule> appliedByBranch = scheduleService.getAppliedByBranch(BRANCH1);

        verify(scheduleRepository, times(1)).findByAppliedIsAndBranchId(true, BRANCH1);
        assertEquals(3, appliedByBranch.size());
    }

    @Test
    void getAppliedForDay() {
        when(scheduleRepository.findByAppliedOnGreaterThanEqualAndAppliedOnLessThanEqual(any(), any())).thenReturn(List.of(sh1, sh2, sh3));
        List<Schedule> appliedForDay = scheduleService.getAppliedForDay();

        verify(scheduleRepository, times(1)).findByAppliedOnGreaterThanEqualAndAppliedOnLessThanEqual(any(LocalDateTime.class), any(LocalDateTime.class));
        assertEquals(3, appliedForDay.size());
    }

    @Test
    void getAppliedByPeriod() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime from = now.minusHours(20);
        LocalDateTime to = now.minusHours(5);

        when(scheduleRepository.findByAppliedOnGreaterThanEqualAndAppliedOnLessThanEqual(from, to)).thenReturn(List.of(sh1, sh2, sh3));
        List<Schedule> appliedForDay = scheduleService.getAppliedByPeriod(from, to);

        verify(scheduleRepository, times(1)).findByAppliedOnGreaterThanEqualAndAppliedOnLessThanEqual(from, to);
        assertEquals(3, appliedForDay.size());
    }
}