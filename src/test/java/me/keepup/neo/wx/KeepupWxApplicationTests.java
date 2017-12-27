package me.keepup.neo.wx;

import me.keepup.neo.wx.utils.WeixinUtil;
import me.keepup.neo.wx.utils.WeixinShopUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeepupWxApplicationTests {

	@Autowired
	private WeixinUtil weixinUtil;
	@Autowired
	private WeixinShopUtil weixinShop;


	@Test
	public void contextLoads() {

		weixinShop.getProductById("pfq4O0pScTxf1-l3tiMmAit9jYFc");


	}





}
