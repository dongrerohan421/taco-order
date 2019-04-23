package com.detroitlabs.tacoorder.tacoorder.service;

import com.detroitlabs.tacoorder.tacoorder.model.OrderDetails;
import com.detroitlabs.tacoorder.tacoorder.model.TacoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderCalculatorImpl implements OrderCalculator {

    @Value("${discount}")
    private int discount;

    @Autowired
    OrderDetails orderDetails;

    @Override
    public ArrayList<OrderDetails> calculateOrder(ArrayList<TacoModel> orderDetails) {
        return calculateOrderTotal(orderDetails);
    }

    private ArrayList<OrderDetails> calculateOrderTotal(ArrayList<TacoModel> ordersList) {

        double totalBilling=0.00;
        int totalNumberOfTacos=0;

        ArrayList<OrderDetails> orderDetailsList = new ArrayList<>();

        for (TacoModel order : ordersList) {
            orderDetails = new OrderDetails();
            orderDetails.setTacoName(order.getTacoName());
            orderDetails.setPrice(returnTacoPrice(order.getTacoName()));

            orderDetails.setQty(order.getQty());
            totalNumberOfTacos += order.getQty();

            orderDetails.setTotal(order.getQty()*orderDetails.getPrice());

            totalBilling = totalBilling+(orderDetails.getTotal());

            orderDetailsList.add(orderDetails);
        }

        if(totalNumberOfTacos >= 4) {
            orderDetailsList.get(orderDetailsList.size()-1).setDiscount(discount);
            totalBilling = totalBilling - (discount * totalBilling) / 100.0;
            orderDetailsList.get(orderDetailsList.size()-1).setFinalBilling(totalBilling);
        }

        return orderDetailsList;
    }

    private double returnTacoPrice(String tacoName) {

        double price=0.00;

        switch (tacoName) {
            case "Veggie":
                price = 2.50;
                break;
            case "Beef":
                price = 3.00;
                break;
            case "Chicken":
                price = 3.00;
                break;
            case "Chorizo":
                price = 3.50;
                break;
            default:
                break;
        }
        return price;
    }
}
