package com.example.banmi.bean;

//我的卡券封装类
public class CardBean {

    private String name;
    private String title;

    @Override
    public String toString() {
        return "CardBean{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
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

    public CardBean() {

        this.name = name;
        this.title = title;
    }
}
