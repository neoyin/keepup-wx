package me.keepup.neo.wx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class BaseDao {

    @Autowired
    protected MongoTemplate template;

}
