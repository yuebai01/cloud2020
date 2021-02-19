package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.HystrixPaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author:lyf
 * @Date 2021-02-04 9:55
 */
@Service
public class HystrixPaymentServiceImpl implements HystrixPaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int TimeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(TimeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id+"\t"+"O(∩_∩)O哈哈~"+"耗时(秒)"+TimeNumber;
    }
}
