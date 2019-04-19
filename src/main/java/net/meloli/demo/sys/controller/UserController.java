package net.meloli.demo.sys.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import net.meloli.demo.sys.base.BaseController;
import net.meloli.demo.sys.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@Api(tags = "UserController")
@RequestMapping("/api/user")
@RestController
public class UserController extends BaseController {


    @PostMapping(value = "/register", consumes = "application/json")
    public Object register(ServletRequest request) throws Exception {
        System.out.println(JSON.toJSONString(request));
        return null;
    }
}
