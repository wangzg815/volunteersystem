package cn.springboot.volunteersystem.mapper;

import cn.springboot.volunteersystem.entity.Publish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/12/18 15:49
 * @Version 1.0
 */
@Repository
@Mapper
public interface IPublishMapper {
    void addPublish(Publish publish);
    List<Publish> findPublishByUserId(Integer userId);
    List<Publish> findAllPublish();

    Publish findPublishByPublishId(Integer publishId);

    void deletePublishByPublishId(Integer publishId);
}
