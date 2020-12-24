package cn.springboot.volunteersystem.controller;

import cn.springboot.volunteersystem.entity.Publish;
import cn.springboot.volunteersystem.entity.PublishAndUserName;
import cn.springboot.volunteersystem.entity.Vjoin;
import cn.springboot.volunteersystem.mapper.IPublishMapper;
import cn.springboot.volunteersystem.service.IJoinService;
import cn.springboot.volunteersystem.service.IPublishService;
import cn.springboot.volunteersystem.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/12/21 21:26
 * @Version 1.0
 */
@Controller
@RequestMapping("join")
public class JoinController {
    @Autowired
    IJoinService joinService;
    @Autowired
    IPublishService publishService;
    @Autowired
    IUserService userService;

    @RequestMapping("isExist")
    public void isExist(Vjoin vjoin, HttpServletResponse response){
        Vjoin join = joinService.isExist(vjoin);
        System.out.println("joinController："+join);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(join);
            System.out.println("json:"+json);
            response.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("addJoin")
    public void addJoin(Vjoin vjoin, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(new Date());
        vjoin.setJoinDate(date);
        System.out.println("addJoin："+vjoin);
        boolean flag = false;
        ObjectMapper mapper = new ObjectMapper();
        try{
            joinService.addJoin(vjoin);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            String json = mapper.writeValueAsString(flag);
            response.getWriter().write(json);
        }

    }

    @RequestMapping("joinOfOwn")
    public void joinOfOwn(Integer userId,HttpServletResponse response){
        List<Vjoin> vjoins = joinService.joinOfOwn(userId);
        List<PublishAndUserName> publishAndUserNames = new ArrayList<>();
        for(Vjoin vjoin : vjoins){
            System.out.println("JoinController:"+vjoin);
            PublishAndUserName publishAndUserName = new PublishAndUserName();
            Publish publish = publishService.findPublishByPublishId(vjoin.getPublishId());
            String name = userService.findUserNameById(userId);
            publishAndUserName.setPublish(publish);
            publishAndUserName.setUsername(name);
            publishAndUserName.setFlag(false);
            publishAndUserNames.add(publishAndUserName);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(publishAndUserNames);
            System.out.println("json："+json);
            response.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("deleteJoin")
    public void deleteJoin(Vjoin vjoin, HttpServletResponse response) {
        System.out.println(vjoin);
        boolean flag = false;
        try {
            joinService.deleteJoin(vjoin);
            flag = true;
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(flag);
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
