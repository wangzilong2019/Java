package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }
    public List<User> findAll() {
        //使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //使用session执行查询所有的方法
        //使用namespace+id定位到sql语句
        List<User> users = session.selectList("com.itheima.domain.User.findAll");
        session.close();
        return users;
    }
}
