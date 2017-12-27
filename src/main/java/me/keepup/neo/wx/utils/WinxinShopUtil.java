package me.keepup.neo.wx.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import me.keepup.neo.wx.bean.WeixinProduct;
import net.sf.ehcache.util.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by neoyin on 2017/12/23.
 */
@Component("weixinShop")
public class WinxinShopUtil {


    @Autowired
    private WeixinUtil weixinUtil;

    static Client client  = ClientBuilder.newClient();


    public WeixinProduct getProductById(String id){
        String token = weixinUtil.getToken();
        if (StringUtils.isEmpty(token))return null;
        WebTarget target = client.target("https://api.weixin.qq.com/merchant/get")
                .queryParam("access_token",token);
        JSONObject object = new JSONObject();
        object.put("product_id",id);
        Response response =  target.request(MediaType.TEXT_PLAIN)
                .post( Entity.text(object.toJSONString()));
        JSONObject jsonObject = response.readEntity(JSONObject.class);

        System.out.println(jsonObject);

        if (jsonObject.containsKey("product_info")){
            JSONObject infoJson = jsonObject.getJSONObject("product_info");
            JSONObject baseJson =  infoJson.getJSONObject("product_base");
            JSONArray sku_list = infoJson.getJSONArray("sku_list");

            String product_id = infoJson.getString("product_id");
            WeixinProduct info = JSONObject.toJavaObject(baseJson,WeixinProduct.class);
            info.setProduct_id(product_id);

            JSONObject temp = sku_list.getJSONObject(0);
            if (temp!=null){
                Double price = temp.getDouble("price");
                Double ori_price = temp.getDouble("ori_price");

                info.setPrice(price);
                info.setOri_price(ori_price);
            }
            System.out.println(info);
            return info;
        }
        return null;
    }


}
