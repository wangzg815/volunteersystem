package cn.springboot.volunteersystem.service.impl;

import cn.springboot.volunteersystem.entity.User;
import cn.springboot.volunteersystem.mapper.IUserMapper;
import cn.springboot.volunteersystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Administrator
 * @Date 2020/12/17 23:24
 * @Version 1.0
 */
@Service
public class UserServiceImp implements IUserService {

    @Autowired
    IUserMapper userMapper;

    @Override
    public void userInsert(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public String findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public User findUserByNameReturnUser(String username) {
        return userMapper.findUserByNameReturnUser(username);
    }

    @Override
    public String findUserNameById(Integer userId) {
        return userMapper.findUserNameById(userId);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }
}
