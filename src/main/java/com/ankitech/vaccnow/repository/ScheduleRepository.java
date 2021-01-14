package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    List<Schedule> findByAppliedIs(boolean isApplied);

    List<Schedule> findByAppliedIsAndBranchId(boolean isApplied, String branchId);

    @Query("{ $and: [ { 'appliedOn': { $gte: ?0 } }, { 'appliedOn': { $lte: ?1 } } ] }")
    List<Schedule> findByAppliedOnGreaterThanEqualAndAppliedOnLessThanEqual(LocalDateTime from, LocalDateTime to);
}
