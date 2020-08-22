package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有信息
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
