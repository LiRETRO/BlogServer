package net.meloli.demo.sys.service.inf;

import net.meloli.demo.sys.dto.FileDto;
import net.meloli.demo.sys.entity.Attachment;
import net.meloli.demo.sys.util.MvcDataDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 上传服务接口
 * @ClassName IUploadService
 * @Author LiRETRO
 * @Date 19-11-07
 * @Version 1.0
 */
public interface IUploadService {

    /**
     * 图片上传
     * @throws Exception
     * @MethodName: pictureUpload
     * @Param: [request]
     * @Return: net.meloli.demo.sys.util.MvcDataDto<java.util.List<net.meloli.demo.sys.dto.FileDto>>
     * @Author: LiRETRO
     * @Date: 19-11-7
    **/
    MvcDataDto<List<FileDto>> pictureUpload(HttpServletRequest request) throws Exception;

    /**
     * 保存附件信息
     * @MethodName: saveAttachment
     * @Param: [attachment]
     * @Return: net.meloli.demo.sys.util.MvcDataDto<net.meloli.demo.sys.entity.Attachment>
     * @Author: LiRETRO
     * @Date: 2019/11/8
    **/
    MvcDataDto<Attachment> saveAttachment(Attachment attachment) throws Exception;
}
