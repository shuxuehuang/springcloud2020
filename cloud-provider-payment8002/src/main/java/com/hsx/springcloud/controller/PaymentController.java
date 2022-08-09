package com.hsx.springcloud.controller;

import com.hsx.springcloud.entities.CommonResult;
import com.hsx.springcloud.entities.Payment;
import com.hsx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/creat")
    public CommonResult creat(@RequestBody Payment payment){
        int res = paymentService.creat(payment);
        log.info("***********添加结果**********：" + res);
        log.info("热部署测试");
        if (res != 0){
            return new CommonResult(200,"添加数据成功"+ "服务端口" + serverPort,res);
        }else {
            return new CommonResult(444,"添加数据失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***********查询结果**********：" + payment);
        if (payment != null){
            return new CommonResult(200,"查询成功" + "服务端口" + serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询id" + id,null);
        }
    }
}
