package com.pretest.Pretest.Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String productId;
    private double qty;
}
