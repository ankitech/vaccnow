package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.model.Slot;
import com.ankitech.vaccnow.repository.SlotRepository;
import com.ankitech.vaccnow.service.implementations.SlotServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SlotServiceImplTest {

    private final String BRANCH1 = "BRANCHIDISTHISFOR1";
    private final String BRANCH2 = "BRANCHIDISTHISFOR2";
    private final Slot s1 = Slot.builder().branch(Branch.builder().id(BRANCH1).build()).start(LocalDateTime.now().plusHours(1).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
    private final Slot s2 = Slot.builder().branch(Branch.builder().id(BRANCH2).build()).start(LocalDateTime.now().plusHours(2).plusMinutes(15)).end(LocalDateTime.now().plusHours(1).plusMinutes(30)).build();
    @Mock
    private SlotRepository slotRepository;
    @InjectMocks
    private SlotServiceImpl slotService;

    @Test
    void getAllSlotsByBranchId() {
        when(slotRepository.findAllByBranchIdAndStartAfter(anyString(), any(LocalDateTime.class))).thenReturn(List.of(s1, s2));
        List<Slot> allSlotsByBranchId = slotService.getAllSlotsByBranchId(BRANCH1);

        verify(slotRepository, times(1)).findAllByBranchIdAndStartAfter(anyString(), any(LocalDateTime.class));
        assertEquals(2, allSlotsByBranchId.size());
    }
}