package cn.springboot.volunteersystem.service.impl;

import cn.springboot.volunteersystem.entity.Vjoin;
import cn.springboot.volunteersystem.mapper.IJoinMapper;
import cn.springboot.volunteersystem.service.IJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/12/19 21:46
 * @Version 1.0
 */
@Service
public class JoinServiceImp implements IJoinService {
    @Autowired
    IJoinMapper joinMapper;

    @Override
    public void addJoin(Vjoin vjoin) {
        joinMapper.addJoin(vjoin);
    }

    @Override
    public Vjoin isExist(Vjoin vjoin) {
        return joinMapper.isExist(vjoin);
    }

    @Override
    public List<Vjoin> joinOfOwn(Integer userId) {
        return joinMapper.joinOfOwn(userId);
    }
    @Override
    public void deleteJoin(Vjoin vjoin) {
        joinMapper.deleteJoin(vjoin);
    }

    @Override
    public void deleteJoinByPublishId(Integer publishId) {
        joinMapper.deleteJoinByPublishId(publishId);
    }
}
