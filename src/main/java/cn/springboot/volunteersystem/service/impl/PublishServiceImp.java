package cn.springboot.volunteersystem.service.impl;

import cn.springboot.volunteersystem.entity.Publish;
import cn.springboot.volunteersystem.mapper.IPublishMapper;
import cn.springboot.volunteersystem.service.IPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/12/18 15:50
 * @Version 1.0
 */
@Service
public class PublishServiceImp implements IPublishService {
    @Autowired
    IPublishMapper publishMapper;
    @Override
    public void addPublish(Publish publish) {
        publishMapper.addPublish(publish);
    }

    @Override
    public List<Publish> findPublishByUserId(Integer userId) {
        return publishMapper.findPublishByUserId(userId);
    }

    @Override
    public List<Publish> findAllPublish() {
        return publishMapper.findAllPublish();
    }

    @Override
    public Publish findPublishByPublishId(Integer publishId) {
        return publishMapper.findPublishByPublishId(publishId);
    }

    @Override
    public void deletePublishByPublishId(Integer publishId) {
        publishMapper.deletePublishByPublishId(publishId);
    }
}
