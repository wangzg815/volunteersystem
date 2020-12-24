package cn.springboot.volunteersystem.service;

import cn.springboot.volunteersystem.entity.User;

/**
 * @Author Administrator
 * @Date 2020/12/17 23:23
 * @Version 1.0
 */
public interface IUserService {
    public void userInsert(User user);
    // 返回username字符串
    String findUserByName(String username);
    // 返回User类
    User findUserByNameReturnUser(String username);

    String findUserNameById(Integer userId);

    void updateUserById(User user);
}
