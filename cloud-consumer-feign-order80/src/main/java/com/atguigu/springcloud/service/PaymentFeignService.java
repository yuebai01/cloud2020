package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:lyf
 * @Date 2021-01-26 16:50
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVER")
@RequestMapping(value = "/payment")
public interface PaymentFeignService {

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeOut();
}
