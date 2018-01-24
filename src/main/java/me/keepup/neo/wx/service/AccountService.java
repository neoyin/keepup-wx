package me.keepup.neo.wx.service;

import me.keepup.neo.wx.bean.Weixin;
import me.keepup.neo.wx.dao.dto.AccountDto;

public interface AccountService {

    AccountDto saveAccount(Weixin weixin);

}
