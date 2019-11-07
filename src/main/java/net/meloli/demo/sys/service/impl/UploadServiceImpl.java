package net.meloli.demo.sys.service.impl;

import net.meloli.demo.sys.dto.FileDto;
import net.meloli.demo.sys.service.inf.IUploadService;
import net.meloli.demo.sys.util.MvcDataDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
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
        byte[] bytes = file.getBytes();
        return fileDto;
    }
}
