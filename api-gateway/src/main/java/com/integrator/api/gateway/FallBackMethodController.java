package com.integrator.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {


    @GetMapping("/ordersServiceFallBack")
    public String orderServiceFallBackMethod(){
        return "Order Service is taking longer than expected" + "Please Try again later";
    }

    @GetMapping("/statusServiceFallBack")
    public String statusServiceFallBackMethod(){
        return "Check Status Service is taking longer than expected" + "Please Try again later";
    }

    @GetMapping("/tradesServiceFallBack")
    public String tradesServiceFallBackMethod(){
        return "Trades Service is taking longer than expected" + "Please Try again later";
    }

    @GetMapping("/holdingsServiceFallBack")
    public String holdingsServiceFallBackMethod(){
        return "Holdings Service is taking longer than expected" + "Please Try again later";
    }
}
