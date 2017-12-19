package me.keepup.neo.wx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class JSPController {


    @RequestMapping("/wel")
    public String input(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "abc");
        return "welcome";
    }
}

