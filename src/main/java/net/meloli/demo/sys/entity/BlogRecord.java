package net.meloli.demo.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class BlogRecord implements Serializable {
    // 主键ID
    private String recordId;
    // blogId
    private String blogId;
    // 访问者IP
    private String visitIp;
    // 暂留字段 用户ID
    private String visitUserId;
    // 访问时间
    private Date visitTime;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getVisitIp() {
        return visitIp;
    }

    public void setVisitIp(String visitIp) {
        this.visitIp = visitIp;
    }

    public String getVisitUserId() {
        return visitUserId;
    }

    public void setVisitUserId(String visitUserId) {
        this.visitUserId = visitUserId;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }
}
