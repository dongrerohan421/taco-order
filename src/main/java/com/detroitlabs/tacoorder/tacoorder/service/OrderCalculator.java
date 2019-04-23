package com.detroitlabs.tacoorder.tacoorder.service;

import com.detroitlabs.tacoorder.tacoorder.model.OrderDetails;
import com.detroitlabs.tacoorder.tacoorder.model.TacoModel;

import java.util.ArrayList;

public interface OrderCalculator {
    public ArrayList<OrderDetails> calculateOrder(ArrayList<TacoModel> orderDetails);
}
