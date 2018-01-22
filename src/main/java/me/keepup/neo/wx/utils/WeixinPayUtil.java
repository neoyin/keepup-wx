package me.keepup.neo.wx.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("weixinPayUtil")
public class WeixinPayUtil {



  public Map<String, String> perPay(String body) throws Exception {

      Map<String, String> map = new HashMap<>();
      //商品简单描述
      map.put("body",body);
      //商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
      map.put("out_trade_no","");
      //订单总金额，单位为分
      map.put("total_fee","");
        //APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
      map.put("spbill_create_ip","");
      //异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
      map.put("notify_url","");
      map.put("trade_type","JSAPI");

      return null;
  }

}
