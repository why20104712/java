package com.why.service.impl;

import com.why.bean.User;
import com.why.dao.UserMapper;
import com.why.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User getEntity(Integer id) {
        return userMapper.getEntity(1);
    }
}
