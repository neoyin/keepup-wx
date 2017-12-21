/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.keepup.neo.wx.web;

import me.keepup.neo.wx.bean.Weixin;
import me.keepup.neo.wx.utils.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class IndexAction extends BaseAction{


    @Autowired
    private WeixinUtil weixinUtil;


    @RequestMapping("/")
    public String welcome(HttpServletRequest requeste, Map<String, Object> model) {

        model.putAll(genWeixinSign(requeste));
        System.out.println(model);
        return "welcome";
    }

    @RequestMapping("/weixin/login")
    public String weixinLogin(@RequestParam("code")String code, Map<String, Object> model){

        System.out.println(code);

        Weixin user = weixinUtil.getWeixinUserInfoByCode(code);
        model.put("user",user);

        String path ="welcome";

        return path;
    }

}