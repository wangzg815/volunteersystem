package cn.springboot.volunteersystem.entity;

import java.io.Serializable;

/**
 * @Author Administrator
 * @Date 2020/12/17 20:48
 * @Version 1.0
 */
//用户表
public class User implements Serializable {
    private Integer id;  //用户id
    private String username;
    private String password;
    private String email;
    private Integer sex;  // 1:男  0:女
    private String address;
    private Integer power;  //0：普通用户 2：管理员

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", power=" + power +
                '}';
    }
}

