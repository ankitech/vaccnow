package com.ankitech.vaccnow.service.interfaces;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Schedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ScheduleService {

    Schedule save(Schedule schedule);

    List<Schedule> findAll();

    Schedule findById(String scheduleId) throws GeneralException;

    Schedule applyVaccine(String scheduleId) throws GeneralException;

    Map<Map.Entry<String, String>, List<Schedule>> getAppliedPerBranch();

    List<Schedule> getAppliedByBranch(String branchId);

    List<Schedule> getAppliedForDay();

    List<Schedule> getAppliedByPeriod(LocalDateTime from, LocalDateTime to);
}
