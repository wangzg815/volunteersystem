package cn.springboot.volunteersystem.mapper;

import cn.springboot.volunteersystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author Administrator
 * @Date 2020/12/17 22:51
 * @Version 1.0
 */
//操作用户表
@Repository
@Mapper
public interface IUserMapper {
    //添加用户
    void insertUser(User user);
    // 返回username字符串
    String findUserByName(String username);

    // 返回User类
    User findUserByNameReturnUser(String username);

    String findUserNameById(Integer userId);

    void updateUserById(User user);
}
