package cn.springboot.volunteersystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Administrator
 * @Date 2020/12/17 20:52
 * @Version 1.0
 */
//发布志愿者招聘表
public class Publish implements Serializable {
    private Integer publishId;
    private String publishTitle; //志愿者招聘主题
    private Integer userId;  //用户id 发布人；
    private String publishContext; //发布内容
    private String publishAddress; //志愿者前往地址
    private String publishCreateTime; // 创建时间
    private String publishDeadTime; // 截止时间

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public String getPublishTitle() {
        return publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPublishContext() {
        return publishContext;
    }

    public void setPublishContext(String publishContext) {
        this.publishContext = publishContext;
    }

    public String getPublishAddress() {
        return publishAddress;
    }

    public void setPublishAddress(String publishAddress) {
        this.publishAddress = publishAddress;
    }

    public String getPublishCreateTime() {
        return publishCreateTime;
    }

    public void setPublishCreateTime(String publishCreateTime) {
        this.publishCreateTime = publishCreateTime;
    }

    public String getPublishDeadTime() {
        return publishDeadTime;
    }

    public void setPublishDeadTime(String publishDeadTime) {
        this.publishDeadTime = publishDeadTime;
    }

    @Override
    public String toString() {
        return "Publish{" +
                "publishId=" + publishId +
                ", publishTitle='" + publishTitle + '\'' +
                ", userId=" + userId +
                ", publishContext='" + publishContext + '\'' +
                ", publishAddress='" + publishAddress + '\'' +
                ", publishCreateTime='" + publishCreateTime + '\'' +
                ", publishDeadTime='" + publishDeadTime + '\'' +
                '}';
    }
}
