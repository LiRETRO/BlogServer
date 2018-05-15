package net.meloli.demo.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name", "FLiNG");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "getValue")
    public String getValue() {
        return "haha";
    }
}
