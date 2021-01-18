package com.ankitech.vaccnow.service.implementations;

import com.ankitech.vaccnow.model.Slot;
import com.ankitech.vaccnow.repository.SlotRepository;
import com.ankitech.vaccnow.service.interfaces.SlotService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {

    private final SlotRepository slotRepository;

    public SlotServiceImpl(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public List<Slot> getAllSlotsByBranchId(String branchId) {
        return slotRepository.findAllByBranchIdAndStartAfter(branchId, LocalDateTime.now());
    }
}
