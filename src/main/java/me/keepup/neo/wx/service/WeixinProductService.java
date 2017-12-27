package me.keepup.neo.wx.service;

import me.keepup.neo.wx.bean.WeixinProduct;

import java.util.List;

public interface WeixinProductService {

    /**
     * 通过id得到微信商品列表
     * @param product_ids
     * @return
     */
    List<WeixinProduct> getProductListByIds(List<String> product_ids);

}
