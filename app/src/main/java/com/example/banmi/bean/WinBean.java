package com.example.banmi.bean;

/**
 * creation time 2019/5/24
 * author oujunlong
 */
public class WinBean {
    private String title;
    private String money;
    private Integer image;
    private String type;

    public WinBean(String title, String money, Integer image, String type) {
        this.title = title;
        this.money = money;
        this.image = image;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WinBean{" +
                "title='" + title + '\'' +
                ", money='" + money + '\'' +
                ", image=" + image +
                ", type='" + type + '\'' +
                '}';
    }
}
