package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

/**
 * @author:lyf
 * @Date 2021-01-20 16:17
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVER";
    @Autowired
    /*@Resource*/
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("要插入的对象"+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping ("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping ("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>();
        }
    }

}
