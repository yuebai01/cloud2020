package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:lyf
 * @Date 2021-02-04 10:06
 */
@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class HystrixPaymentController {
    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        String result= hystrixPaymentService.paymentInfo_OK(id);
        log.info("*******result"+result);
        return result;
    }
    @GetMapping("/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable Integer id){
        String result = hystrixPaymentService.paymentInfo_TimeOut(id);
        log.info("*******result"+result);
        return result;
    }
}
