package me.keepup.neo.wx.dao;

import me.keepup.neo.wx.dao.dto.AccountDto;

public interface AccountDao {

    AccountDto findById(String id);
    AccountDto findByOpenId(String openId);

    AccountDto save(AccountDto accountDto);
}
