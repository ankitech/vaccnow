package com.ankitech.vaccnow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
@Table(name = "schedule")
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
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "allocation_id", referencedColumnName = "id")
    @ApiModelProperty(position = 3, notes = "Allocation id of the schedule", example = "5f1af61e12eb2d004a307116")
    private Allocation allocation;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    @ApiModelProperty(position = 3, notes = "Allocation id of the schedule", example = "5f1af61e12eb2d004a307116")
    private Slot slot;
    @ApiModelProperty(position = 5, notes = "Is the vaccine applied or not", example = "true")
    private boolean applied;
    @ApiModelProperty(position = 6, notes = "Time when vaccine was applied")
    private LocalDateTime appliedOn;
    @ApiModelProperty(position = 7, notes = "branch id of the slot")
    private String paymentType;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @ApiModelProperty(position = 8, notes = "branch id of the allocation", example = "5f1af61e12eb2d004a307116")
    private Branch branch;

}
