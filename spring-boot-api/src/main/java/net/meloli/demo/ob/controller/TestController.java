package net.meloli.demo.ob.controller;

import net.meloli.demo.sys.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newPointCut")
public class TestController extends BaseController {

    @RequestMapping("/test")
    public String test() {
        return "success";
    }
}
