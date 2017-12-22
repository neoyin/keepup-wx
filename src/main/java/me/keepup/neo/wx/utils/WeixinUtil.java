package me.keepup.neo.wx.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.keepup.neo.wx.Const;
import me.keepup.neo.wx.bean.Weixin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import static me.keepup.neo.wx.Const.CacheKey.*;

@Component("weixinUtil")
public class WeixinUtil {

    //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
    //https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi

    private static final Logger LOGGER = LoggerFactory.getLogger(WeixinUtil.class);

    private static final String getTicket_url ="https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi";
    private static final String accessToken_url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

    @Value("${app.weixin.id}")
    private String appId;
    @Value("${app.weixin.key}")
    private String appkey;

    @Autowired
    private CacheManager cacheManager;


    static Client client  = ClientBuilder.newClient();

    public String getToken(){
        WebTarget target = client.target(accessToken_url)
                .queryParam("appid",appId)
                .queryParam("secret",appkey);
        String responseEntity = target.request(MediaType.APPLICATION_JSON).get(String.class);
        return responseEntity;
    }


    private Cache getCache(){
        return cacheManager.getCache(CACHE_NAME);
    }

    private String getTicket(){

        String ticket = getCache().get(TICKET_KEY,String.class);
        if (StringUtils.isEmpty(ticket)){
            String accessToken = getCache().get(TOKEN_KEY,String.class);
            if (StringUtils.isEmpty(accessToken)){
                String tokenResp = getToken();
                if (StringUtils.isEmpty(tokenResp)||!tokenResp.contains("access_token"))return null;
                JSONObject object = JSONObject.parseObject(tokenResp);
                if (!object.containsKey("access_token"))return null;
                accessToken = object.getString("access_token");
                getCache().put(TOKEN_KEY,ticket);
            }

            String ticketResp = getApiTicket(accessToken);
            if (StringUtils.isEmpty(ticketResp)||!ticketResp.contains("ticket"))return null;
            JSONObject ticketObject = JSONObject.parseObject(ticketResp);
            ticket =  ticketObject.getString("ticket");
            getCache().put(TICKET_KEY,ticket);
        }
        return  ticket;
    }
    private String getApiTicket(String accessToken){

        String responseEntity = client.target(getTicket_url)
                .queryParam("access_token",accessToken)
                .request().get(String.class);
        System.out.println("getApiTicket---"+responseEntity);
        return responseEntity;
    }




    /**
     *
     * @param code
     * @return
     */
    protected JSONObject getWeixinAccessToken(String code){

        JSONObject object = null;
        try {
            String response = client.target("https://api.weixin.qq.com/sns/oauth2/access_token")
                    .queryParam("appid",appId)
                    .queryParam("secret",appkey)
                    .queryParam("code",code)
                    .queryParam("grant_type","authorization_code")
                    .request(MediaType.APPLICATION_JSON).get(String.class);
            object =  JSONObject.parseObject(response);
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }
        return object;
    }

    public Weixin getWeixinUserInfoByCode(String code){
        JSONObject object =  getWeixinAccessToken(code);
        if (object==null||object.isEmpty())return null;
        if (object.containsKey("errcode")||object.containsKey("errmsg")) {
            LOGGER.error("获取用户信息失败 "+object.toJSONString());
            return null;
        }
        String access_token=object.getString("access_token");
        String openid=object.getString("openid");
        return getWeixinUserInfoByOpenid(access_token,openid);

    }

    public Weixin getWeixinUserInfoByOpenid(String access_token, String openid){
        JSONObject object =  getWeixinUserJson(access_token,openid);
        if (object==null||object.isEmpty())return null;
        if (object.containsKey("errcode")||object.containsKey("errmsg")) {
            LOGGER.error("获取用户信息失败，无效的access_token或openid,openid="+openid+" "+object.toJSONString());
            return null;
        }
        Weixin weixin = new Weixin();
        weixin.setNickname(object.getString("nickname"));
        weixin.setGender(object.getInteger("sex"));//1:男，2:女
        weixin.setHeadimgurl(object.getString("headimgurl"));
        weixin.setOpenid(object.getString("openid"));
        weixin.setUnionid(object.getString("unionid"));
        weixin.setCity(object.getString("city"));
        return weixin;
    }

    /**
     *
     * @param access_token
     * @param openid
     * @return
     */
    protected static JSONObject getWeixinUserJson( String access_token, String openid) {
        JSONObject object = null;
        try {
            String response = client.target("https://api.weixin.qq.com/sns/userinfo")
                    .queryParam("access_token",access_token)
                    .queryParam("openid",openid)
                    .request(MediaType.APPLICATION_JSON).get(String.class);
            object = JSONObject.parseObject(response);
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }
        return object;
    }

    public Map<String,String> weixinSign(HttpServletRequest request){
        String url = request.getRequestURL().toString();
        String ticket = getTicket();
        return Sign.sign(ticket,url);
    }

}
