package com.pretest.Pretest.Controller;

import com.pretest.Pretest.Entity.Order;
import com.pretest.Pretest.Entity.OrderRequest;
import com.pretest.Pretest.Entity.OrderShipmentResponse;
import com.pretest.Pretest.Entity.Shipment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {
    private Order order;
    private Shipment shipment;

    public OrderController(){
        order= new Order ("Order1", "Prod1", 2.0);
        shipment= new Shipment ("Order1", "Ship1", "Prod1" ,new Date(2021 - 02 - 19), 2.0);
    }
    @GetMapping("/getOrderDetails")
    public OrderShipmentResponse getOrderDetails(@RequestBody OrderRequest orderRequest){
        OrderShipmentResponse response= new OrderShipmentResponse();
        String orderId = orderRequest.getOrderId();
        if(orderId.equals(order.getOrderId()) && orderId.equalsIgnoreCase(shipment.getOrderId())){
            response.setOrder(order);
            response.setShipment(shipment);
        }
        return response;
    }
}