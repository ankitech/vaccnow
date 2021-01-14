package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.MyEntry;
import com.ankitech.vaccnow.model.Schedule;
import com.ankitech.vaccnow.repository.BranchRepository;
import com.ankitech.vaccnow.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, BranchRepository branchRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule save(Schedule schedule) {
        //TODO: implement sending email here
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findById(String scheduleId) throws GeneralException {
        return scheduleRepository.findById(scheduleId).orElseThrow(() -> new GeneralException(HttpStatus.NOT_FOUND, "schedule id " + scheduleId + " not found"));
    }

    @Override
    public Schedule applyVaccine(String scheduleId) throws GeneralException {
        Schedule schedule = findById(scheduleId);
        schedule.setApplied(true);
        schedule.setAppliedOn(LocalDateTime.now());

        Schedule saved = scheduleRepository.save(schedule);
        //TODO: generate Vaccine Certificate
        return saved;
    }

    @Override
    public Map<Map.Entry<String, String>, List<Schedule>> getAppliedPerBranch() {
        Map<String, List<Schedule>> collect = scheduleRepository.findByAppliedIs(true).stream().collect(groupingBy(Schedule::getBranchId));
        Map<Map.Entry<String, String>, List<Schedule>> result = new HashMap<>();

        collect.forEach((branchId, schedules) -> result.put(new MyEntry<>("branchId", branchId), schedules));

        return result;
    }

    @Override
    public List<Schedule> getAppliedByBranch(String branchId) {
        return scheduleRepository.findByAppliedIsAndBranchId(true, branchId);
    }

    @Override
    public List<Schedule> getAppliedForDay() {
        return scheduleRepository.findByAppliedOnGreaterThanEqualAndAppliedOnLessThanEqual(LocalDateTime.now().minusDays(1), LocalDateTime.now());
    }

    @Override
    public List<Schedule> getAppliedByPeriod(LocalDateTime from, LocalDateTime to) {
        return scheduleRepository.findByAppliedOnGreaterThanEqualAndAppliedOnLessThanEqual(from, to);
    }
}
