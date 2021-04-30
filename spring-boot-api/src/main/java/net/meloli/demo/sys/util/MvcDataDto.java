package net.meloli.demo.sys.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@ApiModel("前台的统一返回类")
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MvcDataDto<T> implements Serializable {

    private static final long serialVersionUID = -4505655308965878999L;

    private MvcDataDto() {}

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";

    public static MvcDataDto getInstance() {
        return new MvcDataDto<>().setCode(HttpStatus.PRECONDITION_FAILED.value());
    }

    /**
     * 返回代码
     * @see HttpStatus
     */
    @ApiModelProperty(value = "返回代码, 代表不同的状态", dataType = "Integer", required = true, allowableValues = "(0, infinity)", example = "200")
    private Integer code;
    /**
     * 返回业务处理消息
     */
    @ApiModelProperty(value = "返回业务处理消息", dataType = "String", example = "用户添加成功")
    private String message;
    /**
     * 翻页对象
     */
    @ApiModelProperty(value = "翻页对象", dataType = "Page")
    private Page page;
    /**
     * 返回对象结果
     */
    @ApiModelProperty(value = "返回对象结果, 返回一个Object", dataType = "Object")
    private T data;
    /**
     * 返回参数
     */
    @ApiModelProperty(value = "返回参数", dataType = "Object")
    private Object param;
}
