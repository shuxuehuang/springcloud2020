package com.hsx.springcloud.controller;

import com.hsx.springcloud.entities.CommonResult;
import com.hsx.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private static final String PAYMENT_URL  = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/creat")
    public CommonResult creat(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/creat",
                payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL + "//payment/get/" + id,
                CommonResult.class,id);
    }
}
