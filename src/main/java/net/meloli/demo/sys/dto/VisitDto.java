package net.meloli.demo.sys.dto;

import java.util.Date;

public class VisitDto {
    // blogId
    private String blogId;
    // 请求时间(访问时间)
    private Date requestTime;

    public VisitDto(String blogId, Date requestTime) {
        this.blogId = blogId;
        this.requestTime = requestTime;
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
}
