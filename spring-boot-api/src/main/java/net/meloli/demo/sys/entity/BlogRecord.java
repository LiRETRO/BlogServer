package net.meloli.demo.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
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

}
