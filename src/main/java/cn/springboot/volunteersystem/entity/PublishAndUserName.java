package cn.springboot.volunteersystem.entity;

/**
 * @Author Administrator
 * @Date 2020/12/22 10:42
 * @Version 1.0
 */
public class PublishAndUserName {
    private Publish publish;
    private String username;
    private boolean flag;

    public Publish getPublish() {
        return publish;
    }

    public void setPublish(Publish publish) {
        this.publish = publish;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "PublishAndUserName{" +
                "publish=" + publish +
                ", username='" + username + '\'' +
                ", flag=" + flag +
                '}';
    }
}
