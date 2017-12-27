package me.keepup.neo.wx.service.impl;

import me.keepup.neo.wx.bean.WeixinProduct;
import me.keepup.neo.wx.service.WeixinProductService;
import me.keepup.neo.wx.utils.WeixinShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service("weixinProductService")
public class WeixinProductServiceImpl implements WeixinProductService {

    @Autowired
    private WeixinShopUtil weixinShop;

    @Override
    public List<WeixinProduct> getProductListByIds(List<String> product_ids) {

        List<WeixinProduct> productList = new ArrayList<>();
        if (CollectionUtils.isEmpty(product_ids))return productList;
        for (String pId:product_ids){
            WeixinProduct product = weixinShop.getProductById(pId);
            if (product!=null)productList.add(product);
        }
        return productList;
    }
}
