package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    List<Schedule> findByAppliedIs(boolean isApplied);

    List<Schedule> findByAppliedIsAndBranchId(boolean isApplied, String branchId);
}
