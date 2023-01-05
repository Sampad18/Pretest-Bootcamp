package com.example.supplydemand.Controller;

import com.example.supplydemand.model.Demand;
import com.example.supplydemand.model.InputRequest;
import com.example.supplydemand.model.OutputResponse;
import com.example.supplydemand.model.Supply;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    List<Supply> supplies= new ArrayList<>();
    List<Demand> demands = new ArrayList<>();

    public RestController(){
        supplies.add(new Supply("Product1",10));
        supplies.add(new Supply("Product2",5));
        demands.add(new Demand("Product1",2));
        demands.add(new Demand("Product2",5));
    }

    @GetMapping("/getAvailability")
    public ResponseEntity<OutputResponse> getAvailability(@RequestBody InputRequest inputRequest){


            Supply supply1 = supplies.stream().filter(supply -> supply.getProductId().equals(inputRequest.getProductId())).findFirst().get();
            Demand demand1 = demands.stream().filter(demand -> demand.getProductId().equals(inputRequest.getProductId())).findFirst().get();
            if(supply1.getQuantity()-demand1.getQuantity()>0)
                return new ResponseEntity<>(new OutputResponse(inputRequest.getProductId(),
                        supply1.getQuantity()-demand1.getQuantity()),HttpStatus.OK);
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);


    }


}
