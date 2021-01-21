package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lyf
 * @Date 2021-01-20 11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public static final int success = 0000;
    public static final String successMessage ="操作成功";
    /** 错误 */
    public static final int error = 9999;
    public static final String errorMessage ="操作失败";

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

    public static CommonResult success(){
        return new CommonResult(success,successMessage);
    }

    public static CommonResult error(){
        return new CommonResult(error,errorMessage);
    }

    public static CommonResult success(String message){
        return new CommonResult(success,message);
    }

    public static CommonResult success(Object object){
        return new CommonResult(success,successMessage,object);
    }

    public static CommonResult success(Object object,String message){
        return new CommonResult(success,message,object);
    }


    public static CommonResult error(String message){
        return new CommonResult(error,message);
    }
}
