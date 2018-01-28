package com.vincent.newshop.database.entity;

import java.math.BigDecimal;
import javax.persistence.*;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    private String author;

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
     * @return book_name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
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