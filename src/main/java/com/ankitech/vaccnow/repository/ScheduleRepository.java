package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, String> {

    List<Schedule> findByAppliedIs(boolean isApplied);

    List<Schedule> findByAppliedIsAndBranchId(boolean isApplied, String branchId);

    List<Schedule> findByAppliedOnGreaterThanEqualAndAppliedOnLessThanEqual(LocalDateTime from, LocalDateTime to);
}
