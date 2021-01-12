package com.ankitech.vaccnow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(value = "vaccine")
@ApiModel(description = "Vaccine object")
@Getter
@Setter
@Builder
public class Vaccine {

    @Id
    @ApiModelProperty(position = 1, notes = "unique vaccine id generated and saved in database", accessMode = ApiModelProperty.AccessMode.READ_ONLY, example = "5f1af61e12eb2d004a307116")
    private String id;
    @NotBlank
    @ApiModelProperty(position = 2, notes = "vaccine name", example = "covax", required = true)
    private String name;
    @NotBlank
    @ApiModelProperty(position = 3, notes = "cost of vaccine", example = "1000", required = true)
    private int cost;
}
