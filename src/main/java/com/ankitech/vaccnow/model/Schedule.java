package com.ankitech.vaccnow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Schedule object")
@Getter
@Setter
@Builder
public class Schedule {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ApiModelProperty(position = 1, notes = "unique branch id generated and saved in database", accessMode = ApiModelProperty.AccessMode.READ_ONLY, example = "5f1af61e12eb2d004a307116")
    private String id;
    @NotBlank
    @Email
    @ApiModelProperty(position = 2, notes = "email id", example = "ankitech@gmail.com", required = true)
    private String email;
    @NotBlank
    @ApiModelProperty(position = 3, notes = "allocation id of the schedule", example = "5f1af61e12eb2d004a307116")
    private String allocationId;
    @NotBlank
    @ApiModelProperty(position = 4, notes = "slot id of the schedule", example = "5f1af61e12eb2d004a307116")
    private String slotId;
    @ApiModelProperty(position = 5, notes = "Is the vaccine applied or not", example = "true")
    private boolean applied;
    @ApiModelProperty(position = 6, notes = "Time when vaccine was applied")
    private LocalDateTime appliedOn;
    @ApiModelProperty(position = 7, notes = "branch id of the slot")
    private Payment paymentType;
    @NotBlank
    @ApiModelProperty(position = 8, notes = "branch id of the schedule", example = "5f1af61e12eb2d004a307116")
    private String branchId;

}
