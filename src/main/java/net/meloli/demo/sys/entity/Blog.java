package net.meloli.demo.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    // 主键ID
    private String blogId;
    // 标题
    private String blogTitle;
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

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Date getBlogPublishDate() {
        return blogPublishDate;
    }

    public void setBlogPublishDate(Date blogPublishDate) {
        this.blogPublishDate = blogPublishDate;
    }

    public String getBlogPublisher() {
        return blogPublisher;
    }

    public void setBlogPublisher(String blogPublisher) {
        this.blogPublisher = blogPublisher;
    }

    public Long getBlogVisitedCount() {
        return blogVisitedCount;
    }

    public void setBlogVisitedCount(Long blogVisitedCount) {
        this.blogVisitedCount = blogVisitedCount;
    }

    public String getBlogPublisherCode() {
        return blogPublisherCode;
    }

    public void setBlogPublisherCode(String blogPublisherCode) {
        this.blogPublisherCode = blogPublisherCode;
    }

    public Boolean getBlogIsDel() {
        return blogIsDel;
    }

    public void setBlogIsDel(Boolean blogIsDel) {
        this.blogIsDel = blogIsDel;
    }

    public String getBlogImgPathArr() {
        return blogImgPathArr;
    }

    public void setBlogImgPathArr(String blogImgPathArr) {
        this.blogImgPathArr = blogImgPathArr;
    }
}
