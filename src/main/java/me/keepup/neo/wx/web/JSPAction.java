package me.keepup.neo.wx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class JSPAction extends BaseAction {

    @RequestMapping("/wel")
    public String input(HttpServletRequest requeste, Map<String, Object> model) {

        model.put("time", new Date());
        model.put("message", "abc");
        return "welcome";
    }
}

