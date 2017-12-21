package me.keepup.neo.wx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Map;

@Component("weixinUtil")
public class WeixinUtil {

    //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET

    private static final String accessToken_url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

    @Value("")
    private String appId;
    @Value("")
    private String appkey;

    @Autowired
    private CacheManager cacheManager;



    static Client client  = ClientBuilder.newClient();

    public String getToken(){
        String responseEntity = client.target(accessToken_url)
                .queryParam("appid"+appId)
                .queryParam("secret",appkey)
                .request().get(String.class);
        //System.out.println("---"+responseEntity);
        return responseEntity;
    }


    @Cacheable(cacheNames = "ticket",value = "ticket",key = "ticket")
    public String getTicket(){

        //String token = getToken();
        String token = "";
        System.out.println("getTicket()");
        String ticket = "abccccc";
        return  ticket;
    }
    public String getApiTicket(String accessToken){
        String ticket = "ticketaaa";
        System.out.println("getApiTicket "+ticket);
        return ticket;
    }


    public Map<String,String> weixinSign(HttpServletRequest request){
        String url = request.getRequestURI();
        String ticket = getTicket();
        return Sign.sign(ticket,url);
    }

}
