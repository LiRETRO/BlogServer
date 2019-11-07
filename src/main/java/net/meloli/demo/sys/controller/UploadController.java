package net.meloli.demo.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.meloli.demo.sys.base.BaseController;
import net.meloli.demo.sys.service.inf.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UploadController
 * @Date 19-11-7
 * @Author LiRETRO
 * @Version 1.0
 */
@Api(tags = "上传Controller")
@RestController
@RequestMapping("/api/upload")
public class UploadController extends BaseController {

    @Autowired
    IUploadService iUploadService;

    /**
     * 多文件上传
     * @MethodName: pictureUpload
     * @Param: []
     * @Return: java.lang.Object
     * @Author: LiRETRO
     * @Date: 19-11-7
    **/
    @ApiOperation(value = "图片上传", notes = "图片上传")
    @CrossOrigin
    @PutMapping("/pictureUpload")
    public Object pictureUpload(HttpServletRequest request) throws Exception {
        return iUploadService.pictureUpload(request);
    }
}
