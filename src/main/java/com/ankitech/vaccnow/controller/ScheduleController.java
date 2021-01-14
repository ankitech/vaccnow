package com.ankitech.vaccnow.controller;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Schedule;
import com.ankitech.vaccnow.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Schedule>> getAllSchedule() {

        LOGGER.info("fetching all Schedule");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(scheduleService.findAll(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "save a schedule", response = Schedule.class,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<Schedule> saveQuestion(@Valid @RequestBody Schedule schedule) {

        LOGGER.info("saving schedule for {}", schedule.getEmail());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(scheduleService.save(schedule), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Apply vaacine for the schedule", response = Schedule.class,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/{scheduleId}")
    public ResponseEntity<Schedule> updateQuestion(@PathVariable("scheduleId")
                                                   @NotBlank
                                                   @Size(min = 10, max = 64, message = "schedule id should be between 10 and 64 characters")
                                                           String scheduleId) throws GeneralException {

        LOGGER.info("applying vaccine for schedule : {}", scheduleId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(scheduleService.applyVaccine(scheduleId), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all applied vaccine", response = Map.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/applied/branch")
    public ResponseEntity<Map<Map.Entry<String, String>, List<Schedule>>> getAllAppliedSchedule() {

        LOGGER.info("fetching all applied Schedule by branch");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(scheduleService.getAppliedPerBranch(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all applied vaccine by Branch", response = Schedule.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/applied/branch/{branchId}")
    public ResponseEntity<List<Schedule>> getAllAppliedbyBranch(@PathVariable("branchId") @NotBlank
                                                                @Size(min = 10, max = 64, message = "branchId id should be between 10 and 64 characters")
                                                                        String branchId) {

        LOGGER.info("fetching all applied Schedule by branch");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(scheduleService.getAppliedByBranch(branchId), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all applied vaccine by Branch", response = Schedule.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/applied/day")
    public ResponseEntity<List<Schedule>> getAllAppliedPerDay() {

        LOGGER.info("fetching all applied Schedule for a day");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(scheduleService.getAppliedForDay(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all applied vaccine by Branch", response = Schedule.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/applied/period")
    public ResponseEntity<List<Schedule>> getAllAppliedByPeriod(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                        LocalDateTime from,
                                                                @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                        LocalDateTime to) {

        LOGGER.info("fetching all applied Schedule by period");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(scheduleService.getAppliedByPeriod(from, to), headers, HttpStatus.OK);
    }

}
