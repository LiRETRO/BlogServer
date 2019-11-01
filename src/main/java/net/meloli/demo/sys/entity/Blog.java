package net.meloli.demo.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Blog implements Serializable {
    // 主键ID
    private String blogId;
    // 标题
    private String blogTitle;
    // 副标题
    private String blogSubTitle;
    // 正文（富文本框）
    private String blogContent;
    // 发表时间
    private Date blogPublishDate;
    // 发表人
    private String blogPublisher;
    // 发表人Code
    private String blogPublisherCode;
    // 博客访问数
    private Long blogVisitedCount;
    // 是否删除
    private Boolean blogIsDel;
    // 冗余 图片地址数组
    private String blogImgPathArr;
    // 文章最后编辑时间
    private Date blogLastPublisherDate;
}
