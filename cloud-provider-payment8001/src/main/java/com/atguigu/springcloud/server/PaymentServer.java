package com.atguigu.springcloud.server;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author:lyf
 * @Date 2021-01-20 11:42
 */
public interface PaymentServer {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
