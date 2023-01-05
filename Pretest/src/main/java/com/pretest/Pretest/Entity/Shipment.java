package com.pretest.Pretest.Entity;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment{
    private String orderId;
    private String shipmentId;
    private String productId;
    private Date  shipmentDate;
    private double qty;
}
