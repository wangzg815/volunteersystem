package cn.springboot.volunteersystem.service;

import cn.springboot.volunteersystem.entity.Publish;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/12/18 15:50
 * @Version 1.0
 */
public interface IPublishService {
    void addPublish(Publish publish);
    List<Publish> findPublishByUserId(Integer userId);
    List<Publish> findAllPublish();

    Publish findPublishByPublishId(Integer publishId);

    void deletePublishByPublishId(Integer publishId);
}
