package cn.springboot.volunteersystem.service;

import cn.springboot.volunteersystem.entity.Vjoin;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/12/19 21:45
 * @Version 1.0
 */
public interface IJoinService {
    public void addJoin(Vjoin vjoin);
    Vjoin isExist(Vjoin vjoin);
    List<Vjoin> joinOfOwn(Integer userId);

    void deleteJoin(Vjoin vjoin);

    void deleteJoinByPublishId(Integer publishId);
}
