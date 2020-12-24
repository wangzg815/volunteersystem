package cn.springboot.volunteersystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Administrator
 * @Date 2020/12/17 20:56
 * @Version 1.0
 */
//参与志愿者招聘表
public class Vjoin implements Serializable {
    private Integer joinId;
    private Integer userId;
    private Integer publishId;
    private String joinDate; // 参与时间
    private Publish publish;

    public Integer getJoinId() {
        return joinId;
    }

    public void setJoinId(Integer joinId) {
        this.joinId = joinId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Publish getPublish() {
        return publish;
    }

    public void setPublish(Publish publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Vjoin{" +
                "joinId=" + joinId +
                ", userId=" + userId +
                ", publishId=" + publishId +
                ", joinDate='" + joinDate + '\'' +
                ", publish=" + publish +
                '}';
    }
}
