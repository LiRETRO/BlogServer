package net.meloli.demo.sys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName Attachment
 * @Date 19-11-7
 * @Author LiRETRO
 * @Version 1.0
 */
@ApiModel("附件实体类")
@Data
public class Attachment {

    /**
     * 附件Id
     */
    @ApiModelProperty(value = "附件Id", dataType = "String", required = true)
    private String attachId;
    /**
     * 附件编号
     * 用于业务关联, 多个附件可以使用同一编号
     */
    @ApiModelProperty(value = "附件编号, 用于业务关联, 多个附件可以使用同一编号", dataType = "String", required = true)
    private String attachNo;
    /**
     * 附件新名称
     * 在附件上传后, 会将附件更名为{@link #attachOldName + 时间戳}
     */
    @ApiModelProperty(value = "附件新名称, 在附件上传后, 会将附件更名为{@link #attachOldName + 时间戳}", dataType = "String")
    private String attachName;
    /**
     * 附件老名称
     */
    @ApiModelProperty(value = "附件老名称", dataType = "String")
    private String attachOldName;
    /**
     * 附件老名称
     */
    @ApiModelProperty(value = "附件大小", dataType = "Long")
    private Long attachSize;
    /**
     * 附件路径
     */
    @ApiModelProperty(value = "附件路径", dataType = "String")
    private String attachPath;
    /**
     * 附件类型
     */
    @ApiModelProperty(value = "附件类型", dataType = "String")
    private String attachType;
    /**
     * 上传人
     */
    @ApiModelProperty(value = "上传人", dataType = "String")
    private String uploader;
    /**
     * 上传时间
     */
    @ApiModelProperty(value = "上传时间", dataType = "Date")
    private Date uploadTime;
}
