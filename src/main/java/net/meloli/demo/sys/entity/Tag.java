package net.meloli.demo.sys.entity;

import lombok.Data;

import java.util.Date;

/**
 * 标签
 * @Description 标签
 * @author LiRETRO
 * @Date 2019/11/1 20:23
 */
@Data
public class Tag {

    /**
     * 主键Id
     */
    private String tagId;
    /**
     * 标签名称
     */
    private String tagName;
    /**
     * 绑定文章数
     */
    private Integer archiveCount;
    /**
     * 创建时间
     */
    private Date createDate;
}
