package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有信息
     * @return
     */
    List<User> findAll();
}
