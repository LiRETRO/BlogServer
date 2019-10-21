package net.meloli.demo.sys.util;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class MvcDataDto<T> implements Serializable {

    private static final long serialVersionUID = -4505655308965878999L;

    private MvcDataDto() {}

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";

    public static MvcDataDto getInstance() {
        synchronized (MvcDataDto.class) {
            return new MvcDataDto().setCode(HttpStatus.PRECONDITION_FAILED.value());
        }
    }

    // 返回代码
    private Integer code;
    // 返回消息
    private String message;
    // 翻页对象
    private Page page;
    // 返回结果
    private T data;
    // 返回参数
    private Object param;
    // 返回结果冗余
    private Object resultObjMore;

    public Integer getCode() {
        return code;
    }

    public MvcDataDto setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MvcDataDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public Page getPage() {
        return page;
    }

    public MvcDataDto setPage(Page page) {
        this.page = page;
        return this;
    }

    public T getData() {
        return data;
    }

    public MvcDataDto setData(T data) {
        this.data = data;
        return this;
    }

    public Object getParam() {
        return param;
    }

    public MvcDataDto setParam(Object param) {
        this.param = param;
        return this;
    }

    public Object getResultObjMore() {
        return resultObjMore;
    }

    public MvcDataDto setResultObjMore(Object resultObjMore) {
        this.resultObjMore = resultObjMore;
        return this;
    }
}
