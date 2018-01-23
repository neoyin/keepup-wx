package me.keepup.neo.wx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/note")
public class NoteAction extends BaseAction {

    //上传图片
    @RequestMapping("/upload")
    public String input(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest requeste, Map<String, Object> model) {

   //InputStream inputStream = file.getInputStream();

        return "welcome";
    }
}

