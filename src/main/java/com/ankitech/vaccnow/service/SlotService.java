package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Slot;

import java.util.List;

public interface SlotService {

    List<Slot> getAllSlotsByBranchId(String branchId);
}
