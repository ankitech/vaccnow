package com.ankitech.vaccnow.controller;

import com.ankitech.vaccnow.model.Allocation;
import com.ankitech.vaccnow.service.AllocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Validated
@Api(value = "Branch Controller for managing branch")
@RequestMapping("/v1/allocation")
public class AllocationController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AllocationController.class);

    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @ApiOperation(value = "Get allocations per branch", response = Map.class, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<Map<String, List<Allocation>>> getAllAllocation() {

        LOGGER.info("fetching all branches");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(allocationService.getAllocationPerBranch(), headers, HttpStatus.OK);
    }
}
