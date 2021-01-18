package com.ankitech.vaccnow.controller;

import com.ankitech.vaccnow.model.Vaccine;
import com.ankitech.vaccnow.service.interfaces.VaccineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Validated
@Api(value = "Vaccine Controller for managing vaccine")
@RequestMapping("/v1/vaccine")
public class VaccineController {

    private final static Logger LOGGER = LoggerFactory.getLogger(VaccineController.class);

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @ApiOperation(value = "Get all Vaccines in market", response = Vaccine.class, responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<Vaccine>> getAllQuestion() {

        LOGGER.info("fetching all branches");

        return new ResponseEntity<>(vaccineService.findAllVaccines(), HttpStatus.OK);
    }
}
