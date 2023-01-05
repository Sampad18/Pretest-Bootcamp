package com.pretest.Pretest.Entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderShipmentResponse {
    private Order order;
    private Shipment shipment;
}
