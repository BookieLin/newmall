package com.vincent.newshop.database.entity;

import javax.persistence.*;

@Table(name = "food_cart")
public class FoodCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "food_id")
    private Long foodId;

    private Integer number;

    @Column(name = "user_id")
    private Long userId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return food_id
     */
    public Long getFoodId() {
        return foodId;
    }

    /**
     * @param foodId
     */
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    /**
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}