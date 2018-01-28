package com.vincent.newshop.database.entity;

import javax.persistence.*;

@Table(name = "computer_cart")
public class ComputerCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "computer_id")
    private Long computerId;

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
     * @return computer_id
     */
    public Long getComputerId() {
        return computerId;
    }

    /**
     * @param computerId
     */
    public void setComputerId(Long computerId) {
        this.computerId = computerId;
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