package com.vincent.newshop.database.entity;

import java.math.BigDecimal;
import javax.persistence.*;

public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String brand;

    private String work;

    private String weight;

    private Integer repo;

    private BigDecimal price;

    @Column(name = "good_id")
    private Integer goodId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return work
     */
    public String getWork() {
        return work;
    }

    /**
     * @param work
     */
    public void setWork(String work) {
        this.work = work;
    }

    /**
     * @return weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return repo
     */
    public Integer getRepo() {
        return repo;
    }

    /**
     * @param repo
     */
    public void setRepo(Integer repo) {
        this.repo = repo;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
}