package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author:lyf
 * @Date 2021-01-26 16:50
 */
@Component
@FeignClient
public interface PaymentFeignService {

    CommonResult<Payment> getPaymentById(@Param("id")Long id);
}
