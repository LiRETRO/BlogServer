package net.meloli.demo.sys.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExceptionDto implements Serializable {

    // 异常ID
    private String exceptionId;
    // 异常信息
    private String exceptionMsg;
    // 异常信息详情+
    private String exceptionMsgDetail;
    // 异常时间
    private Date exceptionTime;
    // 异常发生链
    private String exceptionChain;

}
