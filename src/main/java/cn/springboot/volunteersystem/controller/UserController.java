package cn.springboot.volunteersystem.controller;

import cn.springboot.volunteersystem.entity.User;
import cn.springboot.volunteersystem.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Administrator
 * @Date 2020/12/17 23:30
 * @Version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService userService;
    @CrossOrigin(value = "*")
    @RequestMapping("register")
    public void registerUser(User user,HttpServletResponse response){
        System.out.println(user);

        ObjectMapper mapper = new ObjectMapper();
        boolean flag = false;
        try {
            userService.userInsert(user);
            flag = true;
            String json = mapper.writeValueAsString(flag);
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @CrossOrigin(value = "*")
    @RequestMapping("checkUser")
    public void findUserByName(User user, HttpServletResponse response){
        System.out.println(user);
        String name = userService.findUserByName(user.getUsername());
        boolean flag = name==null?true:false;
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(flag);
            System.out.println(json);
            response.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("login")
    public void findUserByNameReturnUser(User user, HttpServletResponse response){
        System.out.println(user);
        User user1 = userService.findUserByNameReturnUser(user.getUsername());
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(user1);
            response.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("updateUser")
    @Transactional
    public void updateUser(User user, HttpServletResponse response){
        boolean flag = false;
        System.out.println(flag+" "+user);

        try {
            userService.updateUserById(user);
            flag = true;
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(flag);
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
