package me.keepup.neo.wx.utils;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by neoyin on 2017/12/23.
 */
public class HttpClientUtil {


    static CloseableHttpClient httpClient = HttpClients.createDefault();


    public static void getWithBodyHttp(String url,Object body) throws IOException {

        HttpGetWithBodyRequest request = new HttpGetWithBodyRequest(url);
        request.setHeader("Content-Type","text/plain; charset=UTF-8");
        StringEntity entity = new StringEntity(body.toString());
        request.setEntity(entity);
        //发送get请求
        CloseableHttpResponse response = httpClient.execute(request);
        System.out.println("\n ======================= \n");
        System.out.println(response.getEntity());
        if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            System.out.println(response.getEntity());
        }
    }


    public static void main(String[] args) {

        String url ="https://api.weixin.qq.com/merchant/get?access_token=5_NObUbBRNrhf0FLIMx8EQ-YSZUU8ruqyRoRf918jN-N0Dh1J6z72Kw0UGkdt6rNwJk9QIIp8-misnmauMbe2kJ_BSP-H9mhrNcRXxuYOnnO3XW4G8w1F4xPNI69zjxSTjrttZ31lQV7tlmfSUAEPdAAADHS";
        String data = "{\"product_id\":\"icheckpfq4O0swHJ8cS8h2Xmb0FfWxWl6U\"}";
        try {
            getWithBodyHttp(url,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
