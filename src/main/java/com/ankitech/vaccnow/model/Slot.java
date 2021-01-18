package com.ankitech.vaccnow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Slots object")
@Getter
@Setter
@Builder
@Table(name = "slot")
public class Slot {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ApiModelProperty(position = 1, notes = "unique slot id generated and saved in database", accessMode = ApiModelProperty.AccessMode.READ_ONLY, example = "5f1af61e12eb2d004a307116")
    private String id;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @ApiModelProperty(position = 2, notes = "branch id of the allocation", example = "5f1af61e12eb2d004a307116")
    private Branch branch;
    @ApiModelProperty(position = 3, notes = "Slot start time")
    private LocalDateTime start;
    @ApiModelProperty(position = 4, notes = "slot end time")
    private LocalDateTime end;
}
