package com.example.banmi.bean;

//Toolbar上通知按钮列表的封装类
public class NotifactionBean {

    private String name;
    private String title;
    private String date;

    @Override
    public String toString() {
        return "NotifactionBean{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NotifactionBean(String name, String title, String date) {
        this.name = name;
        this.title = title;

        this.date = date;
    }
}
