package com.ankitech.vaccnow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Document(value = "slots")
@ApiModel(description = "Slots object")
@Getter
@Setter
@Builder
public class Slot {

    @Id
    @ApiModelProperty(position = 1, notes = "unique slot id generated and saved in database", accessMode = ApiModelProperty.AccessMode.READ_ONLY, example = "5f1af61e12eb2d004a307116")
    private String id;
    @NotBlank
    @ApiModelProperty(position = 2, notes = "branch id of the slot", example = "5f1af61e12eb2d004a307116")
    private String branchId;
    @NotBlank
    @ApiModelProperty(position = 3, notes = "Slot start time")
    private LocalDateTime from;
    @NotBlank
    @ApiModelProperty(position = 4, notes = "slot end time")
    private LocalDateTime to;
}
