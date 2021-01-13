package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Slot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SlotRepository extends MongoRepository<Slot, String> {

    List<Slot> findAllByBranchIdAndFromAfter(String branchId, LocalDateTime time);
}
