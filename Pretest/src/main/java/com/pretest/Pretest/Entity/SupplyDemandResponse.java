package com.pretest.Pretest.Entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDemandResponse {
    private Supply supply;
    private Demand demand;
}
