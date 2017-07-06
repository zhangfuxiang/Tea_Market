package com.delta.smt.entity;

/**
 * Created by Fuxiang.Zhang on 2017/4/26.
 */

public class ItemMyorderOut {

    private String name;
    private String stats;
    private int count;
    private int money;

    public ItemMyorderOut() {
    }

    public ItemMyorderOut(String name, String stats, int count, int money) {
        this.name = name;
        this.stats = stats;
        this.count = count;
        this.money = money;
    }


    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
