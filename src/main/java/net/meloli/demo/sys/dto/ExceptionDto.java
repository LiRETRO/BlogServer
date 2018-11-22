package net.meloli.demo.sys.dto;

import java.io.Serializable;
import java.util.Date;

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

    public String getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsgDetail() {
        return exceptionMsgDetail;
    }

    public void setExceptionMsgDetail(String exceptionMsgDetail) {
        this.exceptionMsgDetail = exceptionMsgDetail;
    }

    public Date getExceptionTime() {
        return exceptionTime;
    }

    public void setExceptionTime(Date exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    public String getExceptionChain() {
        return exceptionChain;
    }

    public void setExceptionChain(String exceptionChain) {
        this.exceptionChain = exceptionChain;
    }
}
