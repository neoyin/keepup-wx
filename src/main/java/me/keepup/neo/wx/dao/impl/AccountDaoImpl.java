package me.keepup.neo.wx.dao.impl;

import me.keepup.neo.wx.dao.AccountDao;
import me.keepup.neo.wx.dao.BaseDao;
import me.keepup.neo.wx.dao.dto.AccountDto;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDao implements AccountDao {
    @Override
    public AccountDto findById(String id) {
        return template.findById(id,AccountDto.class);
    }

    @Override
    public AccountDto findByOpenId(String openId) {
        Query query = Query.query(Criteria.where("openid").is(openId));
        return template.findOne(query,AccountDto.class);
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        template.save(accountDto);
        return accountDto;
    }
}
