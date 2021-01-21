package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.server.PaymentServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:lyf
 * @Date 2021-01-20 11:46
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentServer paymentServer;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        if (payment==null){
            return CommonResult.error("插入失败");
        }
        log.info("插入的对象"+payment);
        int result = paymentServer.create(payment);
        log.info("插入结果"+result);
        if (result>0){
            return CommonResult.success(payment);
        }else {
            return CommonResult.error();
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentServer.getPaymentById(id);
        log.info("查询结果"+payment);
        if (payment!=null){
            return CommonResult.success(payment);
        }else {
            return CommonResult.error("没有对应记录，id："+id);
        }
    }
}
