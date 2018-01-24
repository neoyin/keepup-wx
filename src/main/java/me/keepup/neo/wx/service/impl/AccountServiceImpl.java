package me.keepup.neo.wx.service.impl;

import me.keepup.neo.wx.bean.Weixin;
import me.keepup.neo.wx.dao.AccountDao;
import me.keepup.neo.wx.dao.dto.AccountDto;
import me.keepup.neo.wx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public AccountDto saveAccount(Weixin weixin) {

        AccountDto account = new AccountDto();
        account.setCreate_time(new Date());
        account.setOpenid(weixin.getOpenid());
        return accountDao.save(account);
    }
}
