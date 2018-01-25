package me.keepup.neo.wx.bean;

public enum  TradeState {

    INIT(0,"创建订单"),
    SUCCESS(1,"支付成功"),
    REFUND(2,"转入退款"),
    NOTPAY(3,"未支付"),
    CLOSED(4,"已关闭"),
    REVOKED(5,"已撤销"),
    USERPAYING(6,"用户支付中"),
    PAYERROR(7,"支付失败"),
    ;

    TradeState(int type, String msg) {

    }
}
