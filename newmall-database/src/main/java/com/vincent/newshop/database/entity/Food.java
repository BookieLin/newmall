package com.vincent.newshop.database.entity;

import java.math.BigDecimal;
import javax.persistence.*;

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String manufacturer;

    @Column(name = "place_origin")
    private String placeOrigin;

    private Integer repo;

    private BigDecimal price;

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
     * @return manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return place_origin
     */
    public String getPlaceOrigin() {
        return placeOrigin;
    }

    /**
     * @param placeOrigin
     */
    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
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
}