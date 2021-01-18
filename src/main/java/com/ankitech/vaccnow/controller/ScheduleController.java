package com.ankitech.vaccnow.controller;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Schedule;
import com.ankitech.vaccnow.service.interfaces.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Validated
@Api(value = "Schedule Controller for managing schedule")
@RequestMapping("/v1/schedule")
public class ScheduleController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @ApiOperation(value = "Get all schedule", response = Schedule.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public List<Schedule> getAllSchedule() {

        LOGGER.info("fetching all Schedule");

        return scheduleService.findAll();
    }

    @ApiOperation(value = "save a schedule", response = Schedule.class,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public Schedule saveQuestion(@Valid @RequestBody Schedule schedule) {

        LOGGER.info("saving schedule for {}", schedule.getEmail());

        return scheduleService.save(schedule);
    }

    @ApiOperation(value = "Apply vaacine for the schedule", response = Schedule.class,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/apply/{scheduleId}")
    public Schedule updateQuestion(@PathVariable("scheduleId")
                                   @NotBlank
                                   @Size(min = 10, max = 64, message = "schedule id should be between 10 and 64 characters")
                                           String scheduleId) throws GeneralException {

        LOGGER.info("applying vaccine for schedule : {}", scheduleId);

        return scheduleService.applyVaccine(scheduleId);
    }

    @ApiOperation(value = "Get all applied vaccine", response = Map.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/applied/branch")
    public Map<Map.Entry<String, String>, List<Schedule>> getAllAppliedSchedule() {

        LOGGER.info("fetching all applied Schedule by branch");

        return scheduleService.getAppliedPerBranch();
    }

    @ApiOperation(value = "Get all applied vaccine by Branch", response = Schedule.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/applied/branch/{branchId}")
    public List<Schedule> getAllAppliedbyBranch(@PathVariable("branchId") @NotBlank
                                                @Size(min = 10, max = 64, message = "branchId id should be between 10 and 64 characters")
                                                        String branchId) {

        LOGGER.info("fetching all applied Schedule by branch");

        return scheduleService.getAppliedByBranch(branchId);
    }

    @ApiOperation(value = "Get all applied vaccine by Branch", response = Schedule.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/applied/day")
    public List<Schedule> getAllAppliedPerDay() {

        LOGGER.info("fetching all applied Schedule for a day");

        return scheduleService.getAppliedForDay();
    }

    @ApiOperation(value = "Get all applied vaccine by Branch", response = Schedule.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/applied/period")
    public List<Schedule> getAllAppliedByPeriod(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                        LocalDateTime from,
                                                @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                        LocalDateTime to) {

        LOGGER.info("fetching all applied Schedule by period");

        return scheduleService.getAppliedByPeriod(from, to);
    }

}
