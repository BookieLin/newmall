package com.vincent.newshop.database.entity;

import javax.persistence.*;

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "good_kind_id")
    private Integer goodKindId;

    @Column(name = "good_id")
    private Integer goodId;

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
     * @return good_kind_id
     */
    public Integer getGoodKindId() {
        return goodKindId;
    }

    /**
     * @param goodKindId
     */
    public void setGoodKindId(Integer goodKindId) {
        this.goodKindId = goodKindId;
    }

    /**
     * @return good_id
     */
    public Integer getGoodId() {
        return goodId;
    }

    /**
     * @param goodId
     */
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
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