package cn.springboot.volunteersystem.mapper;

import cn.springboot.volunteersystem.entity.Vjoin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/12/19 21:26
 * @Version 1.0
 */
@Mapper
@Repository
public interface IJoinMapper {
    void addJoin(Vjoin vjoin);

    Vjoin isExist(Vjoin vjoin);

    List<Vjoin> joinOfOwn(Integer userId);

    void deleteJoin(Vjoin vjoin);

    void deleteJoinByPublishId(Integer publishId);
}
