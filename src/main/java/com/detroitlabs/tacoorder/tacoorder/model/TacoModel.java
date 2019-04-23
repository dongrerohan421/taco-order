package com.detroitlabs.tacoorder.tacoorder.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TacoModel {

    @Value("${}")
    @ApiModelProperty(value = "Taco Name Veggie, Chicken/beef or Chorizo")
    private String tacoName;

    @ApiModelProperty(value = "Taco quantity")
    private int qty;
}
