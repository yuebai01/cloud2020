package com.atguigu.springcloud.service;

/**
 * @author:lyf
 * @Date 2021-02-04 9:54
 */
public interface HystrixPaymentService {
    /**
     * 正常访问肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);
}
