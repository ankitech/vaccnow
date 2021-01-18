package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Slot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SlotRepository extends CrudRepository<Slot, String> {

    List<Slot> findAllByBranchIdAndStartAfter(String branchId, LocalDateTime time);
}
