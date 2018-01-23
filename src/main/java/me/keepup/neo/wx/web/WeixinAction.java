package me.keepup.neo.wx.web;

import com.github.wxpay.sdk.WXPayUtil;
import me.keepup.neo.wx.bean.Weixin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/weixin")
public class WeixinAction extends BaseAction {


    @RequestMapping("/login")
    public String weixinLogin(@RequestParam("code")String code, Map<String, Object> model, HttpServletRequest request){

        System.out.println(code);

        Weixin user = weixinUtil.getWeixinUserInfoByCode(code);
        if (user!=null){
            request.getSession().setAttribute("sess",user);
        }
        model.put("user",user);
        String path ="upload";
        return path;
    }

    //微信预支付
    @RequestMapping("/prepay")
    public String prepay(){
        String nonceStr = WXPayUtil.generateNonceStr();
        return null;
    }
}
