package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.server.PaymentServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        if (payment==null){
            return CommonResult.error("插入失败");
        }
        log.info("插入的对象"+payment);
        int result = paymentServer.create(payment);
        log.info("插入结果"+result);
        if (result>0){
            return CommonResult.success(payment,"端口号："+serverPort);
        }else {
            return CommonResult.error();
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentServer.getPaymentById(id);
        log.info("查询结果"+payment);
        if (payment!=null){
            return CommonResult.success(payment,"端口号："+serverPort);
        }else {
            return CommonResult.error("没有对应记录，id："+id);
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String e:services){
            log.info("element@*****"+e);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
