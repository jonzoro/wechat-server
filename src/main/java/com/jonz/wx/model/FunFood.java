package com.jonz.wx.model;

import javax.persistence.*;

@Table(name = "fun_food")
public class FunFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 菜名
     */
    @Column(name = "dish_name")
    private String dishName;

    /**
     * 餐厅
     */
    private String restaurant;

    /**
     * 类型（饭/面/粥）
     */
    private String type;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取菜名
     *
     * @return dish_name - 菜名
     */
    public String getDishName() {
        return dishName;
    }

    /**
     * 设置菜名
     *
     * @param dishName 菜名
     */
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    /**
     * 获取餐厅
     *
     * @return restaurant - 餐厅
     */
    public String getRestaurant() {
        return restaurant;
    }

    /**
     * 设置餐厅
     *
     * @param restaurant 餐厅
     */
    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * 获取类型（饭/面/粥）
     *
     * @return type - 类型（饭/面/粥）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型（饭/面/粥）
     *
     * @param type 类型（饭/面/粥）
     */
    public void setType(String type) {
        this.type = type;
    }
}