package net.meloli.demo.sys.entity;

import lombok.Data;

@Data
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    // 错误代码
    private Integer code;
    // 错误信息
    private String message;
    // 错误地址
    private String url;
    // 错误数据
    private T data;
}
