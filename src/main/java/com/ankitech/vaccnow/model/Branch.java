package com.ankitech.vaccnow.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(value = "branch")
@ApiModel(description = "Branch object")
@Getter
@Setter
@Builder
public class Branch {

    @Id
    @ApiModelProperty(position = 1, notes = "unique feedback id generated and saved in database", accessMode = ApiModelProperty.AccessMode.READ_ONLY, example = "5f1af61e12eb2d004a307116")
    private String id;
    @NotBlank
    @ApiModelProperty(position = 2, notes = "Branch name", example = "pimple saudagar", required = true)
    private String name;
    @NotBlank
    @ApiModelProperty(position = 3, notes = "Location of the branch", example = "pune", required = true)
    private Location location;
}
