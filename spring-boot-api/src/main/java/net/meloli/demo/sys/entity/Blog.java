package net.meloli.demo.sys.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@ApiModel("博客实体类")
@Data
public class Blog implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "博客主键Id, 自增长", dataType = "Long", required = true, accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long id;
    /**
     * 标题
     */
    @ApiModelProperty(value = "博客标题", dataType = "String")
    private String blogTitle;
    /**
     * 副标题
     */
    @ApiModelProperty(value = "博客副标题", dataType = "String")
    private String blogSubTitle;
    /**
     * 正文（富文本框）
     */
    @ApiModelProperty(value = "博客正文,保存富文本框内内容,带有Html标签", dataType = "String", required = true)
    private String blogContent;
    /**
     * 封面Url
     */
    @ApiModelProperty(value = "博客封面Url", dataType = "String")
    private String blogCoverUrl;
    /**
     * 内容图片附件Id
     */
    @ApiModelProperty(value = "博客内容图片附件Id", dataType = "String")
    private String blogContentAttachNo;
    /**
     * 博客Tags
     */
    @ApiModelProperty(value = "博客的Tags", dataType = "String", example = "Liunx,Redis,Sentinel")
    private String blogTags;
    /**
     * 发表时间
     */
    @ApiModelProperty(value = "博客首次发布时间", dataType = "Date")
    private Date blogPublishDate;
    /**
     * 发表人
     */
    @ApiModelProperty(value = "博客发布人名称", dataType = "String")
    private String blogPublisher;
    /**
     * 发表人Code
     */
    @ApiModelProperty(value = "博客发布人编码", dataType = "String")
    private String blogPublisherCode;
    /**
     * 博客访问数
     */
    @ApiModelProperty(value = "博客访问次数", dataType = "Long")
    private Long blogVisitedCount;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "博客是否删除(true为删除, false为未删除)", dataType = "Boolean", required = true, allowableValues = "true, false")
    private Boolean blogIsDel;
    /**
     * 封面图片地址数组
     */
    @ApiModelProperty(value = "博客封面图片地址数组, 中间用逗号分割", dataType = "String", example = "picture/1.jpg,picture/2.jpg")
    private String blogCoverImagePaths;
    /**
     * 正文图片地址数组
     */
    @ApiModelProperty(value = "博客正文图片地址数组, 中间用逗号分割", dataType = "String", example = "picture/1.jpg,picture/2.jpg")
    private String blogContentImagePaths;
    /**
     * 文章最后编辑时间
     */
    @ApiModelProperty(value = "博客最后发布时间", dataType = "Date")
    private Date blogLastPublishDate;
}
