package me.keepup.neo.wx.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeixinProduct {
    private String product_id;
    private Double price;
    private Double ori_price;

    @Override
    public String toString() {
        return "WeixinProduct{" +
                "product_id='" + product_id + '\'' +
                ", price=" + price +
                ", ori_price=" + ori_price +
                ", name='" + name + '\'' +
                ", img=" + img +
                ", detail=" + detail +
                ", main_img='" + main_img + '\'' +
                ", detail_html='" + detail_html + '\'' +
                ", sku_info=" + sku_info +
                ", property=" + property +
                '}';
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOri_price() {
        return ori_price;
    }

    public void setOri_price(Double ori_price) {
        this.ori_price = ori_price;
    }

    private String name;
    private List<String> img;
    private List<String> detail;
    private String main_img;
    private String detail_html;
    private List<String> sku_info;
    private List<String> property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public List<String> getDetail() {
        return detail;
    }

    public void setDetail(List<String> detail) {
        this.detail = detail;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public String getDetail_html() {
        return detail_html;
    }

    public void setDetail_html(String detail_html) {
        this.detail_html = detail_html;
    }

    public List<String> getSku_info() {
        return sku_info;
    }

    public void setSku_info(List<String> sku_info) {
        this.sku_info = sku_info;
    }

    public List<String> getProperty() {
        return property;
    }

    public void setProperty(List<String> property) {
        this.property = property;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
