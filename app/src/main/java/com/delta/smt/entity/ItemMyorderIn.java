package com.delta.smt.entity;

/**
 * Created by Fuxiang.Zhang on 2017/4/26.
 */

public class ItemMyorderIn {
    private String name;
    private int num;
    private int money;

    public ItemMyorderIn() {
    }

    public ItemMyorderIn(String name, int num, int money) {
        this.name = name;
        this.num = num;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
