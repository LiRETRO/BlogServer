package net.meloli.demo.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.meloli.demo.sys.base.BaseController;
import net.meloli.demo.sys.service.inf.ITagsService;
import net.meloli.demo.sys.util.MvcDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标签Controller
 * @author LiRETRO
 * @Date 2019/11/2 0:54
 */
@Api(tags = "标签接口")
@RestController
@RequestMapping("/api/tags")
public class TagsController extends BaseController {

    @Autowired
    ITagsService tagsService;

    @ApiOperation(value = "获取Tags", notes = "获取Tags")
    @PostMapping(value = "/getTags", consumes = "application/json")
    public Object getTags(@RequestBody MvcDataDto param) throws Exception {
        return tagsService.getTags(param);
    }
}
