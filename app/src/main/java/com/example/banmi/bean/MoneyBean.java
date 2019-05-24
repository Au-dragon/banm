package com.example.banmi.bean;

/**
 * creation time 2019/5/24
 * author oujunlong
 */
public class MoneyBean {
    private String title;
    private String time;
    private String money;

    public MoneyBean(String title, String time, String money) {
        this.title = title;
        this.time = time;
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "MoneyBean{" +
                "title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
