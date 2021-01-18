package com.ankitech.vaccnow.controller;

import com.ankitech.vaccnow.model.Slot;
import com.ankitech.vaccnow.service.interfaces.SlotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@Api(value = "Slot Controller for managing slot")
@RequestMapping("/v1/slot")
public class SlotController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SlotController.class);

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @ApiOperation(value = "Get all available times for a branch", response = Slot.class, responseContainer = "List", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{branchId}")
    public List<Slot> getAllocationByBranchId(@PathVariable("branchId")
                                              @NotBlank
                                              @Size(min = 10, max = 64, message = "branchId id should be between 10 and 64 characters")
                                                      String branchId) {

        LOGGER.info("fetching all branches");

        return slotService.getAllSlotsByBranchId(branchId);
    }
}
