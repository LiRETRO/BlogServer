package net.meloli.demo.sys.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName FileDto
 * @Date 19-11-7
 * @Author LiRETRO
 * @Version 1.0
 */
@ApiModel("文件上传成功返回Dto")
@Data
public class FileDto {

    /**
     * 文件Id
     */
    @ApiModelProperty(value = "文件主键Id", dataType = "String", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String fileId;
    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称", dataType = "String")
    private String fileName;
    /**
     * 文件大小
     */
    @ApiModelProperty(value = "文件大小", dataType = "Double")
    private Double fileSize;
    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型", dataType = "String")
    private String fileType;
    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径", dataType = "String")
    private String filePath;
}
