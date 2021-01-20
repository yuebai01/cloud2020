package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.server.PaymentServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:lyf
 * @Date 2021-01-20 11:46
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentServer paymentServer;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentServer.create(payment);
        log.info("插入结果"+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功");
        }else {
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @PostMapping(value = "/payment/getPaymentById")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentServer.getPaymentById(id);
        log.info("插入结果"+payment);
        if (payment!=null){
            return new CommonResult(200,"查找成功",payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询id"+id,null);
        }
    }
}
