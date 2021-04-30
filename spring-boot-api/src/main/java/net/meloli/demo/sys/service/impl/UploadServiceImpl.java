package net.meloli.demo.sys.service.impl;

import net.coobird.thumbnailator.Thumbnails;
import net.meloli.demo.sys.dto.FileDto;
import net.meloli.demo.sys.entity.Attachment;
import net.meloli.demo.sys.mapper.IAttachmentMapper;
import net.meloli.demo.sys.service.inf.IUploadService;
import net.meloli.demo.sys.util.DateTools;
import net.meloli.demo.sys.util.FileTools;
import net.meloli.demo.sys.util.IdWorker;
import net.meloli.demo.sys.util.MvcDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UploadServiceImpl
 * @Date 19-11-7
 * @Author LiRETRO
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UploadServiceImpl implements IUploadService {

    @Autowired
    IAttachmentMapper attachmentMapper;

    /**
     * 图片上传
     *
     * @param request
     *
     * @MethodName: pictureUpload
     * @Param: [request]
     * @Return: net.meloli.demo.sys.util.MvcDataDto<java.util.List < net.meloli.demo.sys.dto.FileDto>>
     * @Author: LiRETRO
     * @Date: 19-11-7
     */
    @Override
    public MvcDataDto<List<FileDto>> pictureUpload(HttpServletRequest request) throws Exception {
        MvcDataDto<List<FileDto>> dataDto = MvcDataDto.getInstance();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("wangFiles");
        List<FileDto> fileDtoList = new ArrayList<>();
        String attachNo = request.getParameter("attachNo");
        for (MultipartFile file : files) {
            if (file != null) {
                fileDtoList.add(saveFile(file, attachNo));
            }
        }
        if (fileDtoList.size() > 0) {
            dataDto.setData(fileDtoList);
            dataDto.setCode(HttpStatus.OK.value());
            dataDto.setMessage("上传成功");
        } else {
            dataDto.setMessage("上传失败, 未上传任何文件");
        }
        return dataDto;
    }

    /**
     * 保存文件, 并且返回{@link FileDto}
     * @MethodName: saveFile
     * @Param: [file, attachNo]
     * @Return: net.meloli.demo.sys.dto.FileDto
     * @Author: LiRETRO
     * @Date: 19-11-7
    **/
    private FileDto saveFile(MultipartFile file, String attachNo) throws Exception {
        FileDto fileDto = new FileDto();
        if (file.isEmpty()) {
            throw new Exception("文件为空!");
        }
        String attachPath = DateTools.dateToStr(new Date(), "yyyy/MM");
        String savePath = FileTools.createFolder(attachPath);
        // 文件原名
        String filename = file.getOriginalFilename();
        // 文件后缀名
        String ext = filename.substring(filename.lastIndexOf("."), filename.length());
        // 文件新名
        String newFileName = filename.substring(0, filename.lastIndexOf(".")) + "_" + System.currentTimeMillis() + ext;
        // 创建一个文件输出流
        FileOutputStream out = new FileOutputStream(savePath + "/" + newFileName);
        Long size = file.getSize();
        // 获取multipartRequest中的上传文件的输入流
        InputStream in = file.getInputStream();
        // 创建一个缓冲区
        byte buffer[] = new byte[1024];
        // 判断输入流中的数据是否已经读完的标识
        int len = 0;
        // 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
        if(ext.equals(".jpg") || ext.equals(".jpeg") || ext.equals(".png") || ext.equals(".bmp")){
            Thumbnails.of(in).scale(1f).outputQuality(0.8f).toOutputStream(out);
        }else{
            while ((len = in.read(buffer)) > 0) {
                // 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
                // + filename)当中
                out.write(buffer, 0, len);
            }
        }
        // 关闭输出流
        out.close();
        Attachment attachment = new Attachment();
        attachment.setAttachNo(attachNo);
        attachment.setAttachOldName(filename);
        attachment.setAttachName(newFileName);
        attachment.setAttachSize(size);
        attachPath = "uploadFiles/" + attachPath + "/" + newFileName;
        attachment.setAttachPath(attachPath);
        attachment.setAttachType(ext);
        saveAttachment(attachment);
        fileDto.setFileId(attachment.getAttachId());
        fileDto.setFileName(newFileName);
        fileDto.setFilePath(attachPath);
        fileDto.setFileSize(size.doubleValue());
        fileDto.setFileType(ext);
        return fileDto;
    }

    /**
     * 保存附件信息
     * @MethodName: saveAttachment
     * @Param: [attachment]
     * @Return: net.meloli.demo.sys.util.MvcDataDto<net.meloli.demo.sys.entity.Attachment>
     * @Author: LiRETRO
     * @Date: 2019/11/8
     **/
    @Override
    public MvcDataDto<Attachment> saveAttachment(Attachment attachment) {
        MvcDataDto<Attachment> dataDto = MvcDataDto.getInstance();
        attachment.setAttachId(IdWorker.getFullDateId());
        attachment.setUploader("LiRETRO");
        attachment.setUploadTime(new Date());
        attachmentMapper.insert(attachment);
        dataDto.setCode(HttpStatus.OK.value());
        dataDto.setMessage("成功！");
        dataDto.setData(attachment);
        return dataDto;
    }
}
