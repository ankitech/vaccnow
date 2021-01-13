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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @ApiOperation(value = "Get all allocations for a branch", response = Allocation.class, responseContainer = "List", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{branchId}")
    public ResponseEntity<List<Allocation>> getAllocationByBranchId(@PathVariable("branchId")
                                                                    @NotBlank
                                                                    @Size(min = 10, max = 64, message = "branchId id should be between 10 and 64 characters")
                                                                            String branchId) {

        LOGGER.info("fetching all branches");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(allocationService.getAllocationByBranchId(branchId), headers, HttpStatus.OK);
    }
}
