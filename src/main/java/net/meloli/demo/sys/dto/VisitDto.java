package net.meloli.demo.sys.dto;

import java.util.Date;

public class VisitDto {
    // blogId
    private String blogId;
    // 请求时间(访问时间)
    private Date requestTime;
    // 请求IP
    private String ipAddr;

    public VisitDto() {}

    public VisitDto(String blogId, Date requestTime, String ipAddr) {
        this.blogId = blogId;
        this.requestTime = requestTime;
        this.ipAddr = ipAddr;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}
