package com.ankitech.vaccnow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Allocation object")
@Getter
@Setter
@Builder
public class Allocation {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ApiModelProperty(position = 1, notes = "unique allocation id generated and saved in database", accessMode = ApiModelProperty.AccessMode.READ_ONLY, example = "5f1af61e12eb2d004a307116")
    private String id;
    @NotBlank
    @ApiModelProperty(position = 2, notes = "branch id of the allocation", example = "5f1af61e12eb2d004a307116")
    private String branchId;
    @NotBlank
    @ApiModelProperty(position = 3, notes = "vaccine id of the allocation", example = "5f1af61e12eb2d004a307116")
    private String vaccineId;
    @NotBlank
    @ApiModelProperty(position = 4, notes = "count of vaccines", example = "100")
    private int count;
}
