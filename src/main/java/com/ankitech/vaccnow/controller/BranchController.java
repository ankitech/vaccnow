package com.ankitech.vaccnow.controller;

import com.ankitech.vaccnow.exception.GeneralException;
import com.ankitech.vaccnow.model.Branch;
import com.ankitech.vaccnow.service.BranchService;
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

@CrossOrigin
@RestController
@Validated
@Api(value = "Branch Controller for managing branch")
@RequestMapping("/v1/branch")
public class BranchController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BranchController.class);

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @ApiOperation(value = "Get all branches", response = Branch.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<Branch>> getAllQuestion() {

        LOGGER.info("fetching all branches");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(branchService.findAllBranches(), headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Get branch by id", response = Branch.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{branchId}")
    public ResponseEntity<Branch> getBranchById(@PathVariable("branchId")
                                                @NotBlank
                                                @Size(min = 10, max = 64, message = "branchId id should be between 10 and 64 characters")
                                                        String branchId) throws GeneralException {

        LOGGER.info("fetching branch with id {}", branchId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(branchService.findBranchesById(branchId), headers, HttpStatus.OK);
    }

}
