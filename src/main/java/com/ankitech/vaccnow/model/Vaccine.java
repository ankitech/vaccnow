package com.ankitech.vaccnow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Vaccine object")
@Getter
@Setter
@Builder
@Table(name = "vaccine")
public class Vaccine {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ApiModelProperty(position = 1, notes = "unique vaccine id generated and saved in database", accessMode = ApiModelProperty.AccessMode.READ_ONLY, example = "5f1af61e12eb2d004a307116")
    private String id;
    @NotBlank
    @ApiModelProperty(position = 2, notes = "vaccine name", example = "covax", required = true)
    private String name;
    @ApiModelProperty(position = 3, notes = "cost of vaccine", example = "1000", required = true)
    private int cost;
}
