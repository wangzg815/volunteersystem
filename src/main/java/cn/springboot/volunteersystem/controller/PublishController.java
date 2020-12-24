package cn.springboot.volunteersystem.controller;

import cn.springboot.volunteersystem.entity.Publish;
import cn.springboot.volunteersystem.entity.PublishAndUserName;
import cn.springboot.volunteersystem.entity.User;
import cn.springboot.volunteersystem.entity.Vjoin;
import cn.springboot.volunteersystem.service.IJoinService;
import cn.springboot.volunteersystem.service.IPublishService;
import cn.springboot.volunteersystem.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/12/18 15:54
 * @Version 1.0
 */
@Controller
@RequestMapping("publish")
public class PublishController {
    @Autowired
    IPublishService publishService;
    @Autowired
    IUserService userService;
    @Autowired
    IJoinService joinService;
    @CrossOrigin(value = "*")
    @RequestMapping("addPublish")
    public void addPublish(Publish publish, HttpServletResponse response) throws IOException {
        System.out.println("addPublish："+publish);
        ObjectMapper mapper = new ObjectMapper();
        boolean flag = false;
        String json = "";
        try {
            publishService.addPublish(publish);
            flag = true;
            json = mapper.writeValueAsString(flag);
        } catch (Exception e) {
            json = mapper.writeValueAsString(flag);
            e.printStackTrace();
        }finally {
            response.getWriter().write(json);
        }
    }

    @RequestMapping("findOwnPublish")
    public void findPublishByUserId(User user, HttpServletResponse response){
        System.out.println("UserId："+user);
        ObjectMapper mapper = new ObjectMapper();
        List<Publish> publishList = publishService.findPublishByUserId(user.getId());
        try {
            String json = mapper.writeValueAsString(publishList);
            response.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("findAllPublish")
    public void findAllPublish(User user,HttpServletResponse response){
        System.out.println(user);
        List<Publish> publishList = publishService.findAllPublish();
        List<PublishAndUserName> publishAndUserNames = new ArrayList<>();
        for(Publish publish : publishList){
            PublishAndUserName publishAndUserName = new PublishAndUserName();
            Vjoin vjoin = new Vjoin();
            boolean flag = false;
            String username = userService.findUserNameById(publish.getUserId());
            vjoin.setPublishId(publish.getPublishId());
            vjoin.setUserId(user.getId());
            Vjoin exist = joinService.isExist(vjoin);
            System.out.println(exist);
            if(exist == null) flag=true;
            System.out.println(flag);
            publishAndUserName.setPublish(publish);
            publishAndUserName.setUsername(username);
            publishAndUserName.setFlag(flag);
            publishAndUserNames.add(publishAndUserName);
            System.out.println(publishAndUserName);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("testeest");
            String json = mapper.writeValueAsString(publishAndUserNames);
            response.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("deletePublish")
    @Transactional  //使用事务防止错误
    public void deletePublish(Vjoin vjoin, HttpServletResponse response){
        boolean flag = false;
        try {
            publishService.deletePublishByPublishId(vjoin.getPublishId());
            System.out.println("删除publish成功");
            joinService.deleteJoinByPublishId(vjoin.getPublishId());
            System.out.println("删除join表成功");
            ObjectMapper mapper = new ObjectMapper();
            flag = true;
            String json = mapper.writeValueAsString(flag);
            response.getWriter().write(json);
        } catch (Exception e) {
            System.out.println("错误");
            e.printStackTrace();
        } finally {
        }
    }
}
