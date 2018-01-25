package me.keepup.neo.wx.dao.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

public class OrderDto {


    @Id
    private String id;
    /** 产品id */
    private String product_id;
    @Indexed(unique = true)
    /** 微信支付交易id*/
    private String transaction_id;
    /**用户id */
    private String openid;
    /**创建时间*/
    private Date create_time;
    private Date end_time;
    /** 支付金额 精确到分 */
    private int total_fee;
    /**状态
     * SUCCESS—支付成功
     REFUND—转入退款
     NOTPAY—未支付
     CLOSED—已关闭
     REVOKED—已撤销（刷卡支付）
     USERPAYING--用户支付中
     PAYERROR--支付失败(其他原因，如银行返回失败)
     */
    private int trade_state ;
    /**用户定制封面 */
    private String page_path;


}
