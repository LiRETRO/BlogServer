package net.meloli.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyTestController {

    @Value("${name}")
    private String name;
    private String trueName = "FLiNG";

    @RequestMapping(value = "getName", method = RequestMethod.GET)
    public String getMyName(){
        return trueName;
    }
}
