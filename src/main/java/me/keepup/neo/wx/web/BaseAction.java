package me.keepup.neo.wx.web;

import me.keepup.neo.wx.utils.Sign;
import me.keepup.neo.wx.utils.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BaseAction {

    @Autowired
    protected WeixinUtil weixinUtil;

    protected Map<String,String> genWeixinSign(HttpServletRequest request){
        return weixinUtil.weixinSign(request);
    }

}
