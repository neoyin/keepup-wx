package me.keepup.neo.wx.utils;

import org.springframework.stereotype.Component;

@Component("weixinPayUtil")
public class WeixinPayUtil {


    /**
     * appid： wxd930ea5d5a258f4f
       mch_id： 商户Id
       body：商品描述
       nonce_str：随机字符串
     * @param appId
     * @return
     */
    public static String generatePaySign(String appId,String nonceStr){
        return null;
    }

}
