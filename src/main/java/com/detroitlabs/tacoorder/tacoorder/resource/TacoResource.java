package com.detroitlabs.tacoorder.tacoorder.resource;


import com.detroitlabs.tacoorder.tacoorder.model.OrderDetails;
import com.detroitlabs.tacoorder.tacoorder.model.TacoModel;
import com.detroitlabs.tacoorder.tacoorder.service.OrderCalculator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/order")
public class TacoResource {

    @Autowired
    private OrderCalculator orderCalculator;

    @ApiResponses(
            value = {
                    @ApiResponse(code=200, message = "Everything looks great, Thanks for your order"),
                    @ApiResponse(code=400, message = "Something went wrong, Please place your order again.")
            }
    )
    @ApiOperation(value = "This method will post the order to the service")
    @PostMapping(value = "/tacos")
    public ResponseEntity<ArrayList<OrderDetails>> postOrder(@RequestBody ArrayList<TacoModel> orders) {

        ArrayList<OrderDetails> orderDetailsList  = orderCalculator.calculateOrder(orders);

        return new ResponseEntity<ArrayList<OrderDetails>>(orderDetailsList, HttpStatus.OK);
    }
}
