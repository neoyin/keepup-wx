package me.keepup.neo.wx.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by neoyin on 2017/1/4.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Weixin {

    private String refresh_token;
    private String openid;
    private String unionid;
    private String headimgurl;
    private String nickname;
    private Integer gender;
    private String city;
    private Integer subscribe;

    public Weixin() {
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Weixin{" +
                "refresh_token='" + refresh_token + '\'' +
                ", openid='" + openid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                '}';
    }
}
