package net.meloli.demo.sys.util;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Accessors(chain = true)
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
}
