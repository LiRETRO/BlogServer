package net.meloli.demo.sys.entity;

import lombok.Data;

import java.util.Date;

/**
 * 标签关联文章
 * @author LiRETRO
 * @Date 2019/11/1 21:22
 */
@Data
public class TagRefArchive {
    /**
     * 主键Id
     */
    private Integer refId;
    /**
     * 标签Id
     */
    private String tagId;
    /**
     * 博客Id
     */
    private String blogId;
    /**
     * 创建时间
     */
    private Date createDate;
}
