package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Slot;
import com.ankitech.vaccnow.repository.SlotRepository;
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
        return slotRepository.findAllByBranchIdAndFromAfter(branchId, LocalDateTime.now());
    }
}
