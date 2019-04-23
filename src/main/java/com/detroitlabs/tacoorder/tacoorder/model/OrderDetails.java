package com.detroitlabs.tacoorder.tacoorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class OrderDetails {

    @ApiModelProperty(value = "Taco Name Veggie, Chicken/beef or Chorizo")
    private String tacoName;

    @ApiModelProperty(value = "Taco Name price")
    private double price;

    @ApiModelProperty(value = "If order contains 4 or more tacos then discount percentage")
    private int discount;

    @ApiModelProperty(value = "Taco quantity")
    private int qty;

    private double total;

    private double finalBilling;
}
